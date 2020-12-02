package homework.time;

import homework.dao.DBService;
import homework.numbers.Number;
import homework.xml.Murshaller;
import homework.xml.Parser;
import homework.xml.XslTransform;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class WorkTime {

    static ArrayList<Integer> list;

    public static void main(String[] args) throws JAXBException, TransformerException, IOException, URISyntaxException, ParserConfigurationException, org.xml.sax.SAXException {
        long startTime = System.currentTimeMillis();
        System.out.println("Start");
        DBService dbService = new DBService();
        Number number = new Number();
        number.setDbService(dbService);
        int N = 1000000;
        number.setN(N);
        number.addNToTable();
        list = number.getNumbers();
        Murshaller.marshaling();
        XslTransform.Transforming();
        Parser.parrsing();

        long endTime = System.currentTimeMillis();
        long workTime = (endTime - startTime) / 1000;

        System.out.println("Working time is " + workTime + "s");

    }
    public static ArrayList<Integer> getList() {
        return list;
    }
}