package homework.dao;

import java.sql.*;
import java.util.ArrayList;

public class DBService {
    private final Connection connection;

    public DBService() {
        this.connection = getMysqlConnection();
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

    public void cleanUp() throws DBException {
        NumbersDAO dao = new NumbersDAO(connection);
        try {
            dao.dropTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public ArrayList<Integer> getNumbersDB() {
        NumbersDAO numbersDAO = new NumbersDAO(connection);
        return numbersDAO.getNumbersDAO();
    }


    @SuppressWarnings("UnusedDeclaration")
    public static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url
                    .append("jdbc:mysql://")
                    .append("localhost:")
                    .           //host name
                    append("3306/").                //port
                    append("db_magnit?").          //db name
                    append("user=Sergey&").          //login
                    append("password=07081991Sergey&").
                    append("serverTimezone=UTC");       //password

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
