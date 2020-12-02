package homework.numbers;


import homework.base.Main;
import homework.dao.DBException;
import homework.dao.DBService;

import java.util.ArrayList;

public class Number {

    private DBService dbService;
    private int N;
    private final ArrayList<Integer> list = new ArrayList<>(N);

    public void setDbService(DBService dbService) {
        this.dbService = dbService;
    }
    public void setN(int n) {
        N = n;
    }

    public void addNToTable(){
        for (int i = 0; i < N; i++){
          list.add(i);
        }
        try {
            dbService.addToTable(list);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getNumbers() {
        return dbService.getNumbersDB();
    }


    public ArrayList<Integer> getList(ArrayList<Integer> list) {
        return list;
    }
}
