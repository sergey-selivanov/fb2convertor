package org.svs.fb2conv.test;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.Test;
import org.svs.fb2conv.Fb2Creator2;

import fb2Generator.Fb2Creator;

class Fb2Test {

    @Test
    void testFb() {


            /*
            JAXBContext jaxbContext = JAXBContext.newInstance(FictionBook.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            ObjectFactory F = new ObjectFactory();

            FictionBook fbook = new FictionBook();

            FictionBook.Description description = F.createFictionBookDescription();
            TitleInfoType titleInfo = F.createTitleInfoType();


            TextFieldType textFieldType = F.createTextFieldType();
            textFieldType.setValue("Test Book");

            titleInfo.setBookTitle(textFieldType);
            description.setTitleInfo(titleInfo);
            fbook.setDescription(description);
            */

            Fb2Creator2 creator = new Fb2Creator2();
            creator.addContent("Ololololo");
            creator.addContent("More text");
            creator.addContent("Yet more text");
            creator.addContent("Ещё текст");



            String out = "j:/temp/fbook-output.fb2";
            FileOutputStream fos;
            try {
                fos = new FileOutputStream(out);
                creator.getFbook().transferTo(fos);
                fos.close();
            } catch (IOException | JAXBException e) {
                e.printStackTrace();
            }



//            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(out), StandardCharsets.UTF_8);
//            BufferedWriter wr = new BufferedWriter(osw);
//            wr.close();

    }

}
