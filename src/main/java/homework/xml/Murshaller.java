package homework.xml;

import homework.base.Application;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

public class Murshaller {

    static Entries entries;
    static
    {
        ArrayList<Integer> list = Application.getList();
        try {
            entries = new Entries();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        entries.setEntries(new ArrayList<Entry>());

        for (int i =1; i <= list.size(); i++) {
            Entry s1 = new Entry();
            s1.setField(i);


            entries.getEntries().add(s1);
        }
    }

    public static void marshaling() throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //jaxbMarshaller.marshal(entries, System.out);

        jaxbMarshaller.marshal(entries, new File("src/main/java/homework/model/1.xml"));
    }
}
