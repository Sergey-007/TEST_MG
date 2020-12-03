package homework.executor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Executor {
    private final Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public void execUpdate(String update) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(update);
        stmt.close();
    }

    public ArrayList<Integer> execQuery(String query)
            throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(query);
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
    }

}
