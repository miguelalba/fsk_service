package data;

import domain.Language;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LanguageRepository implements BasicRepository<Language> {

    private final Connection connection;

    public LanguageRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Language getById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM language WHERE id = " + id);

        if (resultSet.next()) {
            String code = resultSet.getString("code");
            String name = resultSet.getString("name");

            return new Language(id, code, name);
        } else {
            return null;
        }
    }

    @Override
    public Language[] getAll() throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM language");

        ArrayList<Language> languageList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String code = resultSet.getString("code");
            String name = resultSet.getString("name");

            languageList.add(new Language(id, code, name));
        }

        return languageList.toArray(new Language[0]);
    }
}
