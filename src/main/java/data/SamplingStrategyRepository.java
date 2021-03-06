package data;

import domain.SamplingStrategy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SamplingStrategyRepository implements BasicRepository<SamplingStrategy> {

    private final Connection connection;

    public SamplingStrategyRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public SamplingStrategy getById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM sampling_strategy WHERE id = " + id);

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String comment = resultSet.getString("comment");
            return new SamplingStrategy(id, name, comment);
        } else {
            return null;
        }
    }

    @Override
    public SamplingStrategy[] getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM sampling_strategy");

        ArrayList<SamplingStrategy> strategies = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String comment = resultSet.getString("comment");

            strategies.add(new SamplingStrategy(id, name, comment));
        }

        return strategies.toArray(new SamplingStrategy[0]);
    }
}
