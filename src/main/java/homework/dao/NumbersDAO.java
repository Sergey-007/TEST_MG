package homework.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NumbersDAO {

    private final Connection connection;


    public NumbersDAO(Connection connection) {
        this.connection = connection;
    }

    public void createTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("create table if not exists test (FIELD int, primary key (FIELD))");
        stmt.close();
    }

    public void cleanTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("delete from test;");
        stmt.close();
    }

    public void addN(ArrayList<Integer> list) {
        try {
            for (int i = 1; i <= list.size(); i++) {
                Statement stmt = connection.createStatement();
                stmt.execute("insert into test (FIELD) values ('" + i + "')");
                stmt.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Integer> getNumbersDAO() {
        try {
            Statement stmt = connection.createStatement();
            stmt.execute("select * from test");
            ResultSet result = stmt.getResultSet();
            int id = 0;
            ArrayList<Integer> list = new ArrayList<Integer>();
            while(result.next()) {
                id = result.getInt(1);
                list.add(id);
            }
            result.close();
            stmt.close();
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

}
