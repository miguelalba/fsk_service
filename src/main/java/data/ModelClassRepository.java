package data;

import domain.ModelClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelClassRepository implements BasicRepository<ModelClass> {

    private final Connection connection;

    public ModelClassRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ModelClass getById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM model_class WHERE id = " + id);

        if (resultSet.next()) {
            String name = resultSet.getString("name");

            return new ModelClass(id, name);
        } else {
            return null;
        }
    }

    @Override
    public ModelClass[] getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM model_class");

        ArrayList<ModelClass> classes = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");

            classes.add(new ModelClass(id, name));
        }

        return classes.toArray(new ModelClass[0]);
    }
}
