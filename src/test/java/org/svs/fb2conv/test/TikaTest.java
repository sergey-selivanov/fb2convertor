package org.svs.fb2conv.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.bind.JAXBException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.extractor.EmbeddedDocumentExtractor;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParserConfig;
import org.apache.tika.sax.ToXMLContentHandler;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.svs.fb2conv.Convertor;
import org.svs.fb2conv.ConvertorException;
import org.svs.fb2conv.Fb2ContentHandler;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

class TikaTest {

    private Logger log = LoggerFactory.getLogger(TikaTest.class);

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

//    @Test
//    void test() {
//        fail("Not yet implemented");
//    }

    @Test
    void testParseToHtml() {
        try {
            //String doc = "d:/git/fb2convertor-samples/1.doc";
            //String doc = "d:/git/fb2convertor-samples/2.pdf";
            String doc = "d:/git/fb2convertor-samples/3.pdf";

            //String out = "j:/temp/tika-output-1.html";
            //String out = "j:/temp/tika-output-2.html";
            String out = "j:/temp/tika-output-3.html";

            String s = parseToHTML(doc);
            //System.out.println(s);

            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out), StandardCharsets.UTF_8));
            //BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out)));
            wr.write(s);
            wr.close();

        } catch (IOException | SAXException | TikaException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testParseToFb2() throws IOException {
        //String doc = "d:/git/fb2convertor-samples/1.doc";
        //String doc = "d:/git/fb2convertor-samples/2.pdf";
        //String doc = "d:/git/fb2convertor-samples/3.pdf";
        String doc = "d:/git/fb2convertor-samples/ugh.pdf";

        try {
            InputStream is = parseFb2ContentHandler(doc);

            //String out = "j:/temp/fbook-output.fb2";
            String out = "d:/git/fb2convertor-samples/output/fbook-output.fb2";
            FileOutputStream fos;

            fos = new FileOutputStream(out);
            is.transferTo(fos);
            fos.close();
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testParseDocToFb2() throws IOException {
        String doc = "d:/git/fb2convertor-samples/sudmed.doc";

        try {
            InputStream is = parseFb2ContentHandler(doc);

            String out = "d:/git/fb2convertor-samples/output/fbook-output.fb2";
            FileOutputStream fos;

            fos = new FileOutputStream(out);
            is.transferTo(fos);
            fos.close();
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testParseHtmlToFb2() throws IOException {
        String doc = "d:/git/fb2convertor-samples/gilyar.htm";

        try {
            InputStream is = parseFb2ContentHandler(doc);

            String out = "d:/git/fb2convertor-samples/output/fbook-output.fb2";
            FileOutputStream fos;

            fos = new FileOutputStream(out);
            is.transferTo(fos);
            fos.close();
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void setPdfConfig(ParseContext context) {
        PDFParserConfig pdfConfig = new PDFParserConfig();
        pdfConfig.setExtractInlineImages(true);
        pdfConfig.setExtractUniqueInlineImagesOnly(true);

        context.set(PDFParserConfig.class, pdfConfig);
    }

    @Test
    void testParsePdfToFb2() throws IOException {

        // https://stackoverflow.com/questions/25783212/extract-images-from-pdf-with-apache-tika

        String doc = "d:/git/fb2convertor-samples/ugh.pdf";
        //String doc = "D:/git/fb2convertor-samples/100-rasskazov-o-stykovke.pdf";
        String outPath = "d:/git/fb2convertor-samples/output";

        AutoDetectParser parser = new AutoDetectParser();

        Fb2ContentHandler handler = new Fb2ContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();
        EmbeddedDocumentExtractor embeddedDocumentExtractor = new EmbeddedDocumentExtractor() {

            @Override
            public boolean shouldParseEmbedded(Metadata metadata) {
                //return true;
                return false;
            }

            @Override
            public void parseEmbedded(InputStream stream, ContentHandler handler, Metadata metadata, boolean outputHtml)
                    throws SAXException, IOException {

                log.debug("parseEmbedded");

                Path outputDir = new File(outPath + "_").toPath();
                Files.createDirectories(outputDir);

                Path outputPath = new File(outputDir.toString() + "/" + metadata.get(Metadata.RESOURCE_NAME_KEY)).toPath();
                Files.deleteIfExists(outputPath);
                Files.copy(stream, outputPath);
            }
        };

        context.set(EmbeddedDocumentExtractor.class, embeddedDocumentExtractor);
        context.set(AutoDetectParser.class, parser);
        setPdfConfig(context);


        try (InputStream stream = new FileInputStream(doc)) {
            parser.parse(stream, handler, metadata, context);
        } catch (SAXException | TikaException e) {
            e.printStackTrace();
        }


        try {
            InputStream is = handler.getFbook();
            String out = "d:/git/fb2convertor-samples/output/fbook-output.fb2";
            FileOutputStream fos;

            fos = new FileOutputStream(out);
            is.transferTo(fos);
            fos.close();
        } catch (IOException | JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Test
    void testParsePrint() throws IOException {
        //String doc = "d:/git/fb2convertor-samples/1.doc";
        //String doc = "d:/git/fb2convertor-samples/2.pdf";
        //String doc = "d:/git/fb2convertor-samples/3.pdf";
        String doc = "d:/git/fb2convertor-samples/ugh.pdf";

        parsePrintHandler(doc);
    }

    @Test
    void testConvertor() {
        String doc = "d:/git/fb2convertor-samples/ugh.pdf";
        String out = "d:/git/fb2convertor/build/ugh.fb2";

        Convertor conv = new Convertor();
        try {
            conv.convert(doc, out, true);
        } catch (ConvertorException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    // https://tika.apache.org/1.24.1/examples.html

    public String parseToHTML(String doc) throws IOException, SAXException, TikaException {

        ContentHandler handler = new ToXMLContentHandler();

        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        //try (InputStream stream = TikaTest.class.getResourceAsStream(doc)) {
        try (InputStream stream = new FileInputStream(doc)) {
            parser.parse(stream, handler, metadata);
            return handler.toString();
        }
    }

    public InputStream parseFb2ContentHandler(String doc) throws JAXBException {
        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        Fb2ContentHandler handler = new Fb2ContentHandler();
        try (InputStream stream = new FileInputStream(doc)) {
            parser.parse(stream, handler, metadata);
            //return handler.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TikaException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return handler.getFbook();
    }

    public void parsePrintHandler(String doc) {
        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        Fb2ContentHandler handler = new Fb2ContentHandler();
        try (InputStream stream = new FileInputStream(doc)) {
            parser.parse(stream, new ContentHandler() {

                boolean inElement;

                @Override
                public void startPrefixMapping(String prefix, String uri) throws SAXException {
                    // TODO Auto-generated method stub

                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
                    //System.out.print("- " + qName + ": ");
                    log.debug("-- {}", qName);
                    inElement = true;

                }

                @Override
                public void startDocument() throws SAXException {
                    // TODO Auto-generated method stub

                }

                @Override
                public void skippedEntity(String name) throws SAXException {
                    // TODO Auto-generated method stub

                }

                @Override
                public void setDocumentLocator(Locator locator) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void processingInstruction(String target, String data) throws SAXException {
                    // TODO Auto-generated method stub

                }

                @Override
                public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
                    // TODO Auto-generated method stub

                }

                @Override
                public void endPrefixMapping(String prefix) throws SAXException {
                    // TODO Auto-generated method stub

                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    inElement = false;

                }

                @Override
                public void endDocument() throws SAXException {
                    // TODO Auto-generated method stub

                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    //System.out.println(ch.toString().substring(0, 30) + "...");
//                    for(int i = start; i < start+30; i++) {
//                        System.out.print(ch[i]);
//                    }
                    System.out.println("...");

                    inElement = false;

                }
            }, metadata);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TikaException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
