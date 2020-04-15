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
    public Language getById(String id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM language WHERE code = '" + id + "'");

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String comment = resultSet.getString("comment");

            return new Language(id, name, comment);
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
            String code = resultSet.getString("code");
            String name = resultSet.getString("name");
            String comment = resultSet.getString("comment");

            languageList.add(new Language(code, name, comment));
        }

        return languageList.toArray(new Language[0]);
    }
}
