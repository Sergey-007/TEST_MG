package homework;

import homework.numbers.Total;
import homework.dao.DBService;
import homework.xml.MarshallerXML;
import homework.xml.Parser;
import homework.xml.XslTransform;

import java.util.ArrayList;

public class Application {
    static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println("Start");
        DBService dbService = new DBService();
        Total total = new Total();
        total.setDbService(dbService);
        String N = args[0];
        total.setN(N);
        total.addNToTable();

        list = total.getNumbers();

        MarshallerXML.marshaling();
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
