package data;

import domain.OriginArea;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OriginAreaRepository implements BasicRepository<OriginArea> {

    private final Connection connection;

    public OriginAreaRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public OriginArea getById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM origarea WHERE id = " + id);

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String ssd = resultSet.getString("ssd");

            return new OriginArea(id, name, ssd);
        } else {
            return null;
        }
    }

    @Override
    public OriginArea[] getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM origarea");

        ArrayList<OriginArea> areaList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String ssd = resultSet.getString("ssd");

            areaList.add(new OriginArea(id, name, ssd));
        }

        return areaList.toArray(new OriginArea[0]);
    }
}
