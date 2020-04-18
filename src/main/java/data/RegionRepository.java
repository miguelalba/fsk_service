package data;

import domain.Region;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RegionRepository implements BasicRepository<Region> {

    private final Connection connection;

    public RegionRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Region getById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM region WHERE id = " + id);

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String ssd = resultSet.getString("nuts");

            return new Region(id, name, ssd);
        } else {
            return null;
        }
    }

    @Override
    public Region[] getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM region");

        ArrayList<Region> areaList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String ssd = resultSet.getString("nuts");

            areaList.add(new Region(id, name, ssd));
        }

        return areaList.toArray(new Region[0]);
    }
}
