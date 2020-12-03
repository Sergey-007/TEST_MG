package homework.dao;

import org.h2.jdbcx.JdbcDataSource;

import java.sql.*;
import java.util.ArrayList;

public class DBService {
    private final Connection connection;

    public DBService() {
        this.connection = getH2Connection();
    }

    public void addToTable(ArrayList<Integer> list) throws DBException {
        try {
            connection.setAutoCommit(false);
            NumbersDAO dao = new NumbersDAO(connection);
            dao.createTable();
            dao.cleanTable();
            dao.addN(list);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {
            }
            throw new DBException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }

    public ArrayList<Integer> getNumbersDB() {
        NumbersDAO numbersDAO = new NumbersDAO(connection);
        return numbersDAO.getNumbersDAO();
    }

    public static Connection getH2Connection() {
        try {
            String url = "jdbc:h2:./h2db";
            String name = "tully";
            String pass = "tully";

            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL(url);
            ds.setUser(name);
            ds.setPassword(pass);

            Connection connection = DriverManager.getConnection(url, name, pass);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
