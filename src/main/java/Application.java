import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;

class Application {

    public static void main(String[] args) throws IOException {

        Source[] sources = new Source[]{
                new Source(0, "Events (meeting or conference)", ""),
                new Source(17, "Expert knowledge elicitation", ""),
                new Source(10, "Human health surveillance data", "laboratory diagnostic data")};

        int serverPort = 8000;

        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);

        final ObjectMapper mapper = new ObjectMapper();

        // /api/sources?id=:id
        server.createContext("/api/sources", (exchange -> {

            final String responseText;

            String query = exchange.getRequestURI().getQuery();
            if (query != null) {

                Map<String, String> params = queryToParams(query);

                // If an id is passed then only return the Source with that id. If other parameter is passed, ignore it
                // and return all the sources.
                if (params.containsKey("id")) {
                    int id = Integer.parseInt(params.get("id"));
                    responseText = mapper.writeValueAsString(sources[id]);
                } else {
                    responseText = mapper.writeValueAsString(sources);
                }
            } else {
                // Return all the sources
                responseText = mapper.writeValueAsString(sources);
            }

            exchange.sendResponseHeaders(200, responseText.getBytes().length);
            try (OutputStream output = exchange.getResponseBody()) {
                output.write(responseText.getBytes());
                output.flush();
            }

            exchange.close();
        }));

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
}