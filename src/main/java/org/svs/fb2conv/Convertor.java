package org.svs.fb2conv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

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

    private final Logger log = LoggerFactory.getLogger(Convertor.class);

    public Convertor() {}

    public void convert(String sourceFile, String targetFile, boolean extractImages) throws ConvertorException {

        Path absSourcePath = Path.of(sourceFile).toAbsolutePath();
        Path absTargetPath = Path.of(targetFile).toAbsolutePath();

        log.debug("in: {} out: {}", absSourcePath, absTargetPath);
        log.debug("extractImages: {}", extractImages);

        if(!Files.exists(Path.of(sourceFile))) {
            throw new ConvertorException("Source file does not exist: " + absSourcePath);
        }

        // TODO hide tika config warnings
        //java.util.logging.Logger.getGlobal().setLevel(java.util.logging.Level.OFF);

        Fb2ContentHandler handler = new Fb2ContentHandler();
        AutoDetectParser parser = new AutoDetectParser();
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
                        throws SAXException, IOException {

                    log.debug("parseEmbedded");

                    Path outputDir = new File(targetFile + "-files").toPath();
                    Files.createDirectories(outputDir);

                    Path outputPath = new File(outputDir.toString() + File.separator + metadata.get(Metadata.RESOURCE_NAME_KEY)).toPath();
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

        try (InputStream stream = new FileInputStream(sourceFile)) {
            parser.parse(stream, handler, metadata, context);
        } catch (SAXException | TikaException | IOException e) {
            throw new ConvertorException("Failed to parse " + absSourcePath, e);
        }

        try(InputStream is = handler.getFbook();
                FileOutputStream fos = new FileOutputStream(targetFile)){

            is.transferTo(fos);

        } catch (IOException e) {
            throw new ConvertorException("Failed to save " + absTargetPath, e);
        }
    }
}
