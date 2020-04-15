package data;

import domain.Right;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RightRepository implements BasicRepository<Right> {

    private final Connection connection;

    public RightRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Right getById(String id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM rights WHERE id = '" + id + "'");

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String url = resultSet.getString("url");

            return new Right(id, name, url);
        } else {
            return null;
        }
    }

    @Override
    public Right[] getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM rights");

        ArrayList<Right> rightList = new ArrayList<>();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String url = resultSet.getString("url");

            rightList.add(new Right(id, name, url));
        }

        return rightList.toArray(new Right[0]);
    }
}
