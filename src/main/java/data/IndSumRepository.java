package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class IndSumRepository implements BasicRepository<IndSum> {

    private final Connection connection;

    public IndSumRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public IndSum getById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM ind_sum WHERE id = " + id);

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String ssd = resultSet.getString("ssd");

            return new IndSum(id, name, ssd);
        } else {
            return null;
        }
    }

    @Override
    public IndSum[] getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM ind_sum");

        ArrayList<IndSum> sums = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String ssd = resultSet.getString("ssd");

            sums.add(new IndSum(id, name, ssd));
        }

        return sums.toArray(new IndSum[0]);
    }
}
