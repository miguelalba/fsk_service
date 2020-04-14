import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import domain.*;

class Application {

    public static void main(String[] args) throws IOException, SQLException {

        // Starts DB
        final Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        initDB(connection);

        int serverPort = 8000;

        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);

        final ObjectMapper mapper = new ObjectMapper();

        server.createContext("/api/rights", new RightHandler(mapper, connection));
        server.createContext("/api/sources", new SourceHandler(mapper, connection));

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

    private static class RightHandler implements HttpHandler {

        private final ObjectMapper mapper;
        private final Connection connection;

        RightHandler(ObjectMapper mapper, Connection connection) {
            this.mapper = mapper;
            this.connection = connection;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String responseText = "";

            String query = exchange.getRequestURI().getQuery();
            if (query != null) {

                Map<String, String> params = queryToParams(query);

                if (params.containsKey("id")) {
                    try {
                        String id = params.get("id");
                        Right right = getRight(connection, id);
                        responseText = mapper.writeValueAsString(right);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                // Return all the rights
                try {
                    Right[] rights = getRights(connection);
                    responseText = mapper.writeValueAsString(rights);
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
        }
    }

    private static class SourceHandler implements HttpHandler {

        private final ObjectMapper mapper;
        private final Connection connection;

        SourceHandler(ObjectMapper mapper, Connection connection) {
            this.mapper = mapper;
            this.connection = connection;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
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
        }
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

    private static Right[] getRights(Connection connection) throws SQLException {
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

    private static Right getRight(Connection connection, String id) throws SQLException {
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