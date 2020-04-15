package data;

import domain.Format;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FormatRepository implements BasicRepository<Format> {

    private final Connection connection;

    public FormatRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Format getById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM format WHERE id = " + id);

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String comment = resultSet.getString("comment");

            return new Format(id, name, comment);
        } else {
            return null;
        }
    }

    @Override
    public Format[] getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM format");

        ArrayList<Format> formatList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String comment = resultSet.getString("comment");

            formatList.add(new Format(id, name, comment));
        }

        return formatList.toArray(new Format[0]);
    }
}
