package org.svs.fb2conv;

import java.io.InputStream;
import java.util.Stack;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
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

    public InputStream getFbook() throws JAXBException {
        return creator.getFbook();
    }

    @Override
    public void setDocumentLocator(Locator locator) {
    }

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
    }

    StringBuilder sb;
    PType pType;


    @Override
    @SuppressFBWarnings("SEO_SUBOPTIMAL_EXPRESSION_ORDER")
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

    boolean hyphenRemoved = false;

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

//        log.debug("start {} length {} ch.length {}", start, length, ch.length);

        if(length > 0) {
            if(ch[start + length - 1] == '-') {	// hyphenation at the end of line
                sb.append(ch, start, length - 1);
                hyphenRemoved = true;
            }
            else {
                sb.append(ch, start, length);
                //sb.append(' '); // adds extra space in the middle of line in html. needed for newlines in pdf.
            }
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        log.debug("ignorableWhitespace");

        if(length == 1 && ch[start] == '\n' && hyphenRemoved) {
            log.debug("do not add space: hyphenRemoved");
            hyphenRemoved = false;
        }
        else {
            // TODO how to correctly handle newlines in pdf? will double spaces occur?
            sb.append(' ');
        }
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        log.debug("processingInstruction: {}", target);
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
        log.debug("skipped entity: {}", name);
    }

}
