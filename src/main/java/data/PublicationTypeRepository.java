package data;

import domain.PublicationType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PublicationTypeRepository implements BasicRepository<PublicationType> {

    private final Connection connection;

    public PublicationTypeRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public PublicationType getById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM publication_type WHERE id = '" + id + "'");

        if (resultSet.next()) {
            String shortName = resultSet.getString("shortName");
            String fullName = resultSet.getString("fullName");

            return new PublicationType(id, shortName, fullName);
        } else {
            return null;
        }
    }

    @Override
    public PublicationType[] getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM publication_type");

        ArrayList<PublicationType> typeList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String shortName = resultSet.getString("shortName");
            String fullName = resultSet.getString("fullName");

            typeList.add(new PublicationType(id, shortName, fullName));
        }

        return typeList.toArray(new PublicationType[0]);
    }
}
