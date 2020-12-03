package homework.base;

import homework.numbers.Number;
import homework.dao.DBService;
import homework.xml.Murshaller;
import homework.xml.Parser;
import homework.xml.XslTransform;

import java.util.ArrayList;

public class Application {
    static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println("Start");
        DBService dbService = new DBService();
        Number number = new Number();
        number.setDbService(dbService);
        String N = args[0];
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
