package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.Software;

public class SoftwareRepository implements BasicRepository<Software> {

    private final Connection connection;

    public SoftwareRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Software getById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM software WHERE id = " + id);

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            return new Software(id, name);
        } else {
            return null;
        }
    }

    @Override
    public Software[] getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM software");

        ArrayList<Software> softwareList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");

            softwareList.add(new Software(id, name));
        }

        return softwareList.toArray(new Software[0]);
    }
}
