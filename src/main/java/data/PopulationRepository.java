package data;

import domain.Population;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PopulationRepository implements BasicRepository<Population> {

    private final Connection connection;

    public PopulationRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Population getById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM population WHERE id = " + id);

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String foodon = resultSet.getString("foodon");

            return new Population(id, name, foodon);
        } else {
            return null;
        }
    }

    @Override
    public Population[] getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM population");

        ArrayList<Population> populationList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String foodon = resultSet.getString("foodon");

            populationList.add(new Population(id, name, foodon));
        }

        return populationList.toArray(new Population[0]);
    }
}
