package org.svs.fb2conv;

import java.io.InputStream;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import fb2.PType;

public class Fb2ContentHandler implements ContentHandler {

    private Logger log = LoggerFactory.getLogger(Fb2ContentHandler.class);

    Fb2Creator2 creator;
    boolean inPElement;
    Stack<String> inElementName = new Stack<>();

    public Fb2ContentHandler() {

        log.debug("Fb2ContentHandler()");

        creator = new Fb2Creator2();
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
    PType pType;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

        log.debug("<{}", qName);
        inElementName.push(qName);

        String lastText = "";
        if(sb != null) {
            lastText = sb.toString();
        }

        sb = new StringBuilder();

        if("p".equals(qName)) {
            inPElement = true;
            sb = new StringBuilder();
            pType = creator.createP();
        }

        if("div".equals(qName)) {
            if(inPElement) {
                log.debug("=== div: in P element");
            }
            else {
                //creator.nextSection();

                // div is new page in pdf?
            }
        }

        if("i".equals(qName)) {
            if(!lastText.isEmpty()) {
                pType.getContent().add(lastText.trim());
            }
        }
        if("b".equals(qName)) {
            if(!lastText.isEmpty()) {
                pType.getContent().add(lastText.trim());
            }
        }
        //if("".equals(qName)) {}

        if("img".equals(qName)) {
            //int i = 0;
            log.debug("img src: {}", atts.getValue("src"));
            log.debug("img alt: {}", atts.getValue("alt"));

            creator.addContent("<<< " + atts.getValue("src") + " >>>");
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        log.debug("{}>", qName);
        inElementName.pop();

        if("i".equals(qName)) {
            creator.addEmphasis(pType, sb.toString().trim());
            sb = new StringBuilder();
        }
        if("b".equals(qName)) {
            creator.addStrong(pType, sb.toString().trim());
            sb = new StringBuilder();
        }
        //if("".equals(qName)) {}

        if("p".equals(qName)) {

            inPElement = false;
            pType.getContent().add(sb.toString().trim());
            creator.addP(pType);
        }



    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
//        if(inPElement) {
//            if(ch[ch.length - 1] == '-') {	// hyphenation at the end of line
//                sb.append(ch, 0, ch.length - 1);
//            }
//            else {
//                sb.append(ch);
//                sb.append(' ');
//            }
//        }

        log.debug("start {} length {} ch.length {}", start, length, ch.length);

        if(length > 0) {
            if(ch[start + length - 1] == '-') {	// hyphenation at the end of line
                sb.append(ch, start, length - 1);
            }
            else {
                sb.append(ch, start, length);
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
