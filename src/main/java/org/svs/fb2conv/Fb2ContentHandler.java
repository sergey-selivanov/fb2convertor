package org.svs.fb2conv;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import fb2Generator.Fb2Creator;

public class Fb2ContentHandler implements ContentHandler {

    private Logger log = LoggerFactory.getLogger(Fb2ContentHandler.class);

    Fb2Creator creator;
    boolean inPElement;

    public Fb2ContentHandler() {

        log.debug("Fb2ContentHandler()");

        creator = new Fb2Creator("Test Book");
        inPElement = false;
    }

    public InputStream getFbook() {
        return creator.getFbook();
    }

    @Override
    public void setDocumentLocator(Locator locator) {
        // TODO Auto-generated method stub

    }

    @Override
    public void startDocument() throws SAXException {
        // TODO Auto-generated method stub

    }

    @Override
    public void endDocument() throws SAXException {
        // TODO Auto-generated method stub

    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        // TODO Auto-generated method stub

    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        // TODO Auto-generated method stub

    }

    StringBuilder sb;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

        log.debug("> {}", qName);

        if("p".equals(qName)) {
            inPElement = true;
            sb = new StringBuilder();
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        log.debug("< {}", qName);

        if("p".equals(qName)) {

            inPElement = false;
            creator.addContent(sb.toString());
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(inPElement) {
// TODO must use start-length params
            if(ch[ch.length - 1] == '-') {	// hyphenation at end of line
                sb.append(ch, 0, ch.length - 1);
            }
            else {
                sb.append(ch);
                sb.append(' ');
            }
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        // TODO Auto-generated method stub

    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        // TODO Auto-generated method stub

    }

    @Override
    public void skippedEntity(String name) throws SAXException {
        // TODO Auto-generated method stub

    }

}
