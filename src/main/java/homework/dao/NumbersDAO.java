package homework.dao;

import homework.executor.Executor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class NumbersDAO {

    private Executor executor;

    public NumbersDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists test (FIELD int, primary key (FIELD))");
    }

    public void cleanTable() throws SQLException {
        executor.execUpdate("delete from test;");
    }

    public void addN(ArrayList<Integer> list) {
        try {
            for (int i = 1; i <= list.size(); i++) {
                executor.execUpdate("insert into test (FIELD) values ('" + i + "')");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Integer> getNumbersDAO() {
        try {
            return executor.execQuery("select * from test");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

}
