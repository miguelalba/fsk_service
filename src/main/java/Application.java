import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import data.*;
import domain.FishArea;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

class Application {

    public static void main(String[] args) throws IOException, SQLException {

        // Starts DB
        final Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        loadInitialData(connection);

        int serverPort = 8000;
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);

        final ObjectMapper mapper = new ObjectMapper();
        AvailabilityRepository availabilityRepository = new AvailabilityRepository(connection);
        FishAreaRepository fishAreaRepository = new FishAreaRepository(connection);
        FormatRepository formatRepository = new FormatRepository(connection);
        HazardTypeRepository hazardTypeRepository = new HazardTypeRepository(connection);
        LanguageRepository languageRepository = new LanguageRepository(connection);
        LanguageWrittenInRepository languageWrittenInRepository = new LanguageWrittenInRepository(connection);
        OriginAreaRepository originAreaRepository = new OriginAreaRepository(connection);
        PackagingRepository packagingRepository = new PackagingRepository(connection);
        ProductMatrixRepository productMatrixRepository = new ProductMatrixRepository(connection);
        ProductTreatmentRepository productTreatmentRepository = new ProductTreatmentRepository(connection);
        ProductionMethodRepository productionMethodRepository = new ProductionMethodRepository(connection);
        PublicationStatusRepository statusRepository = new PublicationStatusRepository(connection);
        PublicationTypeRepository publicationTypeRepository = new PublicationTypeRepository(connection);
        RightRepository rightRepository = new RightRepository(connection);
        SoftwareRepository softwareRepository = new SoftwareRepository(connection);
        SourceRepository sourceRepository = new SourceRepository(connection);
        UnitCategoryRepository unitCategoryRepository = new UnitCategoryRepository(connection);

        server.createContext("/api/availability", new BasicHandler(mapper, availabilityRepository));
        server.createContext("/api/fish_area", new BasicHandler(mapper, fishAreaRepository));
        server.createContext("/api/format", new BasicHandler(mapper, formatRepository));
        server.createContext("/api/hazard_type", new BasicHandler(mapper, hazardTypeRepository));
        server.createContext("/api/language", new BasicHandler(mapper, languageRepository));
        server.createContext("/api/language_written_in", new BasicHandler(mapper, languageWrittenInRepository));
        server.createContext("/api/origin_area", new BasicHandler(mapper, originAreaRepository));
        server.createContext("/api/packaging", new BasicHandler(mapper, packagingRepository));
        server.createContext("/api/product_matrix", new BasicHandler(mapper, productMatrixRepository));
        server.createContext("/api/product_treatment", new BasicHandler(mapper, productTreatmentRepository));
        server.createContext("/api/production_method", new BasicHandler(mapper, productionMethodRepository));
        server.createContext("/api/publicationstatus", new BasicHandler(mapper, statusRepository));
        server.createContext("/api/publicationtype", new BasicHandler(mapper, publicationTypeRepository));
        server.createContext("/api/right", new BasicHandler(mapper, rightRepository));
        server.createContext("/api/software", new BasicHandler(mapper, softwareRepository));
        server.createContext("/api/source", new BasicHandler(mapper, sourceRepository));
        server.createContext("/api/unit_category", new BasicHandler(mapper, unitCategoryRepository));

        server.setExecutor(null); // Creates a default executor
        server.start();
    }

    private static void loadInitialData(Connection connection) throws IOException {

        String dataFolder = Application.class.getResource("data/initialdata").getFile();

        Files.list(Paths.get(dataFolder)).forEach(file -> {
            try {
                String script = new String(Files.readAllBytes(file));
                Statement statement = connection.createStatement();
                statement.execute(script);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private static class BasicHandler implements HttpHandler {

        private final ObjectMapper mapper;
        private final BasicRepository<?> repository;

        BasicHandler(ObjectMapper mapper, BasicRepository<?> repository) {
            this.mapper = mapper;
            this.repository = repository;
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
                        int id = Integer.parseInt(params.get("id"));
                        try (OutputStream output = exchange.getResponseBody()) {
                            mapper.writeValue(output, repository.getById(id));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    try (OutputStream output = exchange.getResponseBody()) {
                        mapper.writeValue(output, repository.getAll());
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace(); // TODO: ...
                }
            }

            exchange.close();
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
}