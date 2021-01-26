package org.svs.fb2conv;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import fb2.BodyType;
import fb2.FictionBook;
import fb2.ObjectFactory;
import fb2.PType;
import fb2.SectionType;
import fb2.StyleType;

public class Fb2Creator2 {
    private static final ObjectFactory F = new ObjectFactory();

    private final Marshaller jaxbMarshaller;
    private FictionBook fbook;
    private BodyType body;
    private SectionType section;


    public Fb2Creator2() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(FictionBook.class);
            jaxbMarshaller = jaxbContext.createMarshaller();
        } catch (JAXBException e) {
            throw new UnsupportedOperationException();
        }

        fbook = new FictionBook();
    }

    public Fb2Creator2 nextSection() {
        if (body == null) {
            body = F.createBodyType();
        }
        //if (section == null) {
            section = F.createSectionType();
            body.getSection().add(section);
        //}
        return this;
    }

    public Fb2Creator2 addContent(String content) {
        if (body == null) {
            nextSection();
        }
        PType pType = F.createPType();
        pType.getContent().add(content);
        section.getPOrImageOrPoem().add(F.createSectionTypeP(pType));
        fbook.setBody(body);
        return this;
    }

    public PType createP() {
        PType pType = F.createPType();
        return pType;
    }

    public PType addEmphasis(PType p, String text) {
        StyleType st = F.createStyleType();
        st.getContent().add(text);
        p.getContent().add(F.createStyleTypeEmphasis(st));

        return p;
    }

    public PType addStrong(PType p, String text) {
        StyleType st = F.createStyleType();
        st.getContent().add(text);
        p.getContent().add(F.createStyleTypeStrong(st));

        return p;
    }

    public Fb2Creator2 addP(PType p) {
        if (body == null) {
            nextSection();
        }

        section.getPOrImageOrPoem().add(F.createSectionTypeP(p));
        fbook.setBody(body);
        return this;
    }


    public InputStream getFbook() {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(fbook, out);

            return new ByteArrayInputStream(out.toByteArray());
        } catch (JAXBException e) {
            throw new UnsupportedOperationException();
        }
    }

}
