import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Application {

    public static void main(String[] args) throws IOException, SQLException {

        // Starts DB
        final Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        initDB(connection);

        int serverPort = 8000;

        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);

        final ObjectMapper mapper = new ObjectMapper();

        // /api/sources?id=:id
        server.createContext("/api/sources", exchange -> {

            String responseText = "";

            String query = exchange.getRequestURI().getQuery();
            if (query != null) {

                Map<String, String> params = queryToParams(query);

                // If an id is passed then only return the Source with that id. If other parameter is passed, ignore it
                // and return all the sources.
                if (params.containsKey("id")) {
                    try {
                        int id = Integer.parseInt(params.get("id"));
                        Source source = getSource(connection, id);
                        responseText = mapper.writeValueAsString(source);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Source[] sources = getSources(connection);
                        responseText = mapper.writeValueAsString(sources);
                    } catch (SQLException exception) {
                        exception.printStackTrace(); // TODO: ...
                    }
                }
            } else {
                // Return all the sources
                try {
                    Source[] sources = getSources(connection);
                    responseText = mapper.writeValueAsString(sources);
                } catch (SQLException exception) {
                    exception.printStackTrace(); // TODO: ...
                }
            }

            exchange.sendResponseHeaders(200, responseText.getBytes().length);
            try (OutputStream output = exchange.getResponseBody()) {
                output.write(responseText.getBytes());
                output.flush();
            }

            exchange.close();
        });

        server.setExecutor(null); // Creates a default executor
        server.start();
    }

    private static Map<String, String> queryToParams(String query) {
        Map<String, String> params = new HashMap<>();

        for (String param : query.split("&")) {
            String[] pair = param.split("=");
            if (pair.length == 2) {
                params.put(pair[0], pair[1]);
            }
        }

        return params;
    }

    private static void initDB(Connection connection) throws SQLException, IOException {
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

    private static int getRowCount(Connection connection, String table) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(1) FROM " + table);
        resultSet.next();

        return resultSet.getInt(1);
    }

    private static Source[] getSources(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from sources");

        ArrayList<Source> sourceList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String comment = resultSet.getString("comment");

            sourceList.add(new Source(id, name, comment));
        }

        return sourceList.toArray(new Source[0]);
    }

    private static Source getSource(Connection connection, int id) throws SQLException {
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
}