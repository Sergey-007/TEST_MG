package homework.numbers;

import homework.dao.DBException;
import homework.dao.DBService;

import java.util.ArrayList;

public class Total {

    private DBService dbService;
    private int N;
    private final ArrayList<Integer> list = new ArrayList<>(N);

    public void setDbService(DBService dbService) {
        this.dbService = dbService;
    }
    public void setN(String n) {
        N = Integer.parseInt(n);
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

}
