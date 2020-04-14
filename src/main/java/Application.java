import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import domain.Right;
import domain.Source;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

class Application {

    public static void main(String[] args) throws IOException, SQLException {

        // Starts DB
        final Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        final Crud crud = new Crud(connection);

        int serverPort = 8000;

        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);

        final ObjectMapper mapper = new ObjectMapper();

        server.createContext("/api/rights", new RightHandler(mapper, crud));
        server.createContext("/api/sources", new SourceHandler(mapper, crud));

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
        private final Crud crud;

        RightHandler(ObjectMapper mapper, Crud crud) {
            this.mapper = mapper;
            this.crud = crud;
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
                        Right right = crud.getRight(id);
                        responseText = mapper.writeValueAsString(right);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                // Return all the rights
                try {
                    Right[] rights = crud.getRights();
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
        private final Crud crud;

        SourceHandler(ObjectMapper mapper, Crud crud) {
            this.mapper = mapper;
            this.crud = crud;
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
                        Source source = crud.getSource(id);
                        responseText = mapper.writeValueAsString(source);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                // Return all the sources
                try {
                    Source[] sources = crud.getSources();
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
}