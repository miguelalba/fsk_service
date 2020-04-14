import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import domain.Availability;
import domain.Format;
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

        server.createContext("/api/availability", new AvailabilityHandler(mapper, crud));
        server.createContext("/api/format", new FormatHandler(mapper, crud));
        server.createContext("/api/right", new RightHandler(mapper, crud));
        server.createContext("/api/source", new SourceHandler(mapper, crud));

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

    private static class AvailabilityHandler implements HttpHandler {

        private final ObjectMapper mapper;
        private final Crud crud;

        AvailabilityHandler(ObjectMapper mapper, Crud crud) {
            this.mapper = mapper;
            this.crud = crud;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            // length 0 to send a variable amount of data (1 or many items)
            exchange.sendResponseHeaders(200, 0);

            String query = exchange.getRequestURI().getQuery();
            if (query != null) {

                Map<String, String> params = queryToParams(query);

                if (params.containsKey("id")) {
                    try {
                        String id = params.get("id");
                        Availability right = crud.getAvailability(id);
                        try (OutputStream output = exchange.getResponseBody()) {
                            mapper.writeValue(output, right);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                // Return all the rights
                try {
                    Availability[] availabilities = crud.getAvailabilities();
                    try (OutputStream output = exchange.getResponseBody()) {
                        mapper.writeValue(output, availabilities);
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace(); // TODO: ...
                }
            }

            exchange.close();
        }
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

            // length 0 to send a variable amount of data (1 or many items)
            exchange.sendResponseHeaders(200, 0);

            String query = exchange.getRequestURI().getQuery();
            if (query != null) {

                Map<String, String> params = queryToParams(query);

                if (params.containsKey("id")) {
                    try {
                        String id = params.get("id");
                        Right right = crud.getRight(id);
                        try (OutputStream output = exchange.getResponseBody()) {
                            mapper.writeValue(output, right);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                // Return all the rights
                try {
                    Right[] rights = crud.getRights();
                    try (OutputStream output = exchange.getResponseBody()) {
                        mapper.writeValue(output, rights);
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace(); // TODO: ...
                }
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

            // length 0 to send a variable amount of data (1 or many items)
            exchange.sendResponseHeaders(200, 0);

            String query = exchange.getRequestURI().getQuery();
            if (query != null) {

                Map<String, String> params = queryToParams(query);

                // If an id is passed then only return the Source with that id. If other parameter is passed, ignore it
                // and return all the sources.
                if (params.containsKey("id")) {
                    try {
                        int id = Integer.parseInt(params.get("id"));
                        Source source = crud.getSource(id);
                        try (OutputStream output = exchange.getResponseBody()) {
                            mapper.writeValue(output, source);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                // Return all the sources
                try {
                    Source[] sources = crud.getSources();
                    try (OutputStream output = exchange.getResponseBody()) {
                        mapper.writeValue(output, sources);
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace(); // TODO: ...
                }
            }

            exchange.close();
        }
    }

    private static class FormatHandler implements HttpHandler {

        private final ObjectMapper mapper;
        private final Crud crud;

        FormatHandler(ObjectMapper mapper, Crud crud) {
            this.mapper = mapper;
            this.crud = crud;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            // length 0 to send a variable amount of data (1 or many items)
            exchange.sendResponseHeaders(200, 0);

            String query = exchange.getRequestURI().getQuery();
            if (query != null) {

                Map<String, String> params = queryToParams(query);

                // If an id is passed then only return the Source with that id. If other parameter is passed, ignore it
                // and return all the sources.
                if (params.containsKey("id")) {
                    try {
                        String id = params.get("id");
                        Format format = crud.getFormat(id);
                        try (OutputStream output = exchange.getResponseBody()) {
                            mapper.writeValue(output, format);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                // Return all the sources
                try {
                    Format[] formats = crud.getFormats();
                    try (OutputStream output = exchange.getResponseBody()) {
                        mapper.writeValue(output, formats);
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace(); // TODO: ...
                }
            }

            exchange.close();
        }
    }
}