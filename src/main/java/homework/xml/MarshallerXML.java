package homework.xml;

import homework.Application;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

public class MarshallerXML {

    static Entries entries;
    static
    {
        ArrayList<Integer> list = Application.getList();
        try {
            entries = new Entries();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        entries.setEntries(new ArrayList<>());

        for (int i =1; i <= list.size(); i++) {
            Entry s1 = new Entry();
            s1.setField(i);


            entries.getEntries().add(s1);
        }
    }

    public static void marshaling() throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
        javax.xml.bind.Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //jaxbMarshaller.marshal(entries, System.out);

        jaxbMarshaller.marshal(entries, new File("src/main/resources/1.xml"));
    }
}
