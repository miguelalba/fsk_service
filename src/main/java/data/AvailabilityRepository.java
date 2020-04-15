package data;

import domain.Availability;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AvailabilityRepository implements BasicRepository<Availability> {

    private final Connection connection;

    public AvailabilityRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Availability getById(String id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM availability WHERE id = '" + id + "'");

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String comment = resultSet.getString("comment");

            return new Availability(id, name, comment);
        } else {
            return null;
        }
    }

    @Override
    public Availability[] getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM availability");

        ArrayList<Availability> availabilityList = new ArrayList<>();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String comment = resultSet.getString("comment");

            availabilityList.add(new Availability(id, name, comment));
        }

        return availabilityList.toArray(new Availability[0]);
    }
}
