package org.svs.fb2conv.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.ToXMLContentHandler;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

class TikaTest {

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
    void testParse() {
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
}
