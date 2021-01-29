package org.svs.fb2conv;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.bind.JAXBException;

import org.apache.tika.config.TikaConfig;
import org.apache.tika.exception.TikaException;
import org.apache.tika.extractor.EmbeddedDocumentExtractor;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParserConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class Convertor {

    private final transient Logger log = LoggerFactory.getLogger(Convertor.class);

    //public Convertor() {}

    public void convert(final String sourceFile, final String targetFile, final boolean extractImages)
            throws ConvertorException {

        Path absSourcePath = Path.of(sourceFile).toAbsolutePath();
        Path absTargetPath = Path.of(targetFile).toAbsolutePath();

        log.debug("in: {} out: {}", absSourcePath, absTargetPath);
        log.debug("extractImages: {}", extractImages);

        if(!Files.exists(Path.of(sourceFile))) {
            throw new ConvertorException("Source file does not exist: " + absSourcePath);
        }

        Fb2ContentHandler handler = new Fb2ContentHandler();

        TikaConfig tikaConfig = null;
        try(InputStream is = Convertor.class.getResourceAsStream("/tika-config.xml")){
            tikaConfig = new TikaConfig(is);
        } catch (IOException | TikaException | SAXException e) {
            throw new ConvertorException("Failed to load tika config", e);
        }

        AutoDetectParser parser = new AutoDetectParser(tikaConfig);
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();

        if(extractImages) {
            log.debug("extractImages");

            EmbeddedDocumentExtractor embeddedDocumentExtractor = new EmbeddedDocumentExtractor() {

                @Override
                public boolean shouldParseEmbedded(Metadata metadata) {
                    return true;
                }

                @Override
                public void parseEmbedded(InputStream stream, ContentHandler handler, Metadata metadata, boolean outputHtml)
                        throws IOException {

                    log.debug("parseEmbedded");

                    //Path outputDir = new File(targetFile + "-files").toPath();
                    Path outputDir = Path.of(targetFile + "-files");
                    Files.createDirectories(outputDir);

                    //Path outputPath = new File(outputDir.toString() + File.separator + metadata.get(Metadata.RESOURCE_NAME_KEY)).toPath();
                    Path outputPath = Path.of(outputDir.toString(), metadata.get(Metadata.RESOURCE_NAME_KEY));
                    Files.deleteIfExists(outputPath);
                    Files.copy(stream, outputPath);
                }
            };

            context.set(EmbeddedDocumentExtractor.class, embeddedDocumentExtractor);

            PDFParserConfig pdfConfig = new PDFParserConfig();
            pdfConfig.setExtractInlineImages(true);
            pdfConfig.setExtractUniqueInlineImagesOnly(true);
            context.set(PDFParserConfig.class, pdfConfig);
        }

        context.set(AutoDetectParser.class, parser);

        //try (InputStream stream = new FileInputStream(sourceFile)) {
        try (InputStream stream = Files.newInputStream(Path.of(sourceFile))) {
            parser.parse(stream, handler, metadata, context);
        } catch (SAXException | TikaException | IOException e) {
            throw new ConvertorException("Failed to parse " + absSourcePath, e);
        }

        try(InputStream is = handler.getFbook();
                //FileOutputStream fos = new FileOutputStream(targetFile)){
                OutputStream fos = Files.newOutputStream(Path.of(targetFile))){

            is.transferTo(fos);

        } catch (IOException | JAXBException e) {
            throw new ConvertorException("Failed to save " + absTargetPath, e);
        }
    }
}
