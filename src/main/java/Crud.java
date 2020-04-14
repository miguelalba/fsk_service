import domain.Right;
import domain.Source;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Crud {

    private final Connection connection;

    public Crud(Connection connection) throws IOException, SQLException {
        this.connection = connection;

        initDB();
    }

    private void initDB() throws SQLException, IOException {
        Map<String, String> tableFiles = new HashMap<>();
        tableFiles.put("sources", "sources.sql");
        tableFiles.put("rights", "rights.sql");

        for (Map.Entry<String, String> entry : tableFiles.entrySet()) {
            String sourceFile = Application.class.getClassLoader().getResource(entry.getValue()).getFile();
            String sql = new String(Files.readAllBytes(Paths.get(sourceFile)));

            Statement statement = connection.createStatement();
            statement.execute(sql);

            String tableName = entry.getKey();
            int numberOfRows = getRowCount(connection, tableName);
            System.out.printf("Table %s created with %d rows\n", tableName, numberOfRows);
        }
    }

    private int getRowCount(Connection connection, String table) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(1) FROM " + table);
        resultSet.next();

        return resultSet.getInt(1);
    }

    public Source[] getSources() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM sources");

        ArrayList<Source> sourceList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String comment = resultSet.getString("comment");

            sourceList.add(new Source(id, name, comment));
        }

        return sourceList.toArray(new Source[0]);
    }

    public Source getSource(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM sources WHERE id = " + id);

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String comment = resultSet.getString("comment");

            return new Source(id, name, comment);
        } else {
            return null;
        }
    }

    public Right[] getRights() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM rights");

        ArrayList<Right> rightList = new ArrayList<>();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String url = resultSet.getString("url");

            rightList.add(new Right(id, name, url));
        }

        return rightList.toArray(new Right[0]);
    }

    public Right getRight(String id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM rights WHERE id = '" + id + "'");

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String url = resultSet.getString("url");

            return new Right(id, name, url);
        } else {
            return null;
        }
    }
}
