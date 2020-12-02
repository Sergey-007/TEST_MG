package homework.base;

import homework.numbers.Number;
import homework.dao.DBService;
import homework.xml.Murshaller;
import homework.xml.Parser;
import homework.xml.XslTransform;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception {
        DBService dbService = new DBService();
        Number number = new Number();
        number.setDbService(dbService);

        System.out.println("Введите число");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        number.setN(N);
        number.addNToTable();

        list = number.getNumbers();

        Murshaller.marshaling();
        XslTransform.Transforming();
        Parser.parrsing();
//
    }

    public static ArrayList<Integer> getList() {
        return list;
    }
}
