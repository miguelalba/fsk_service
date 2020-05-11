import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import data.AvailabilityRepository;
import data.BasicRepository;
import data.CollectionToolRepository;
import data.CountryRepository;
import data.FishAreaRepository;
import data.FormatRepository;
import data.HazardRepository;
import data.HazardTypeRepository;
import data.IndSumRepository;
import data.LaboratoryAccreditationRepository;
import data.LanguageRepository;
import data.LanguageWrittenInRepository;
import data.ModelClassRepository;
import data.ModelEquationClassRepository;
import data.ModelSubclassRepository;
import data.PackagingRepository;
import data.ParameterDistributionRepository;
import data.ParameterSourceRepository;
import data.ParameterSubjectRepository;
import data.PopulationRepository;
import data.ProductMatrixRepository;
import data.ProductTreatmentRepository;
import data.ProductionMethodRepository;
import data.PublicationStatusRepository;
import data.PublicationTypeRepository;
import data.RegionRepository;
import data.RightRepository;
import data.SamplingMethodRepository;
import data.SamplingPointRepository;
import data.SamplingProgramRepository;
import data.SamplingStrategyRepository;
import data.SoftwareRepository;
import data.SourceRepository;
import data.StatusRepository;
import data.UnitCategoryRepository;
import data.UnitRepository;

@SuppressWarnings("restriction")
class Application {

    public static void main(String[] args) throws IOException, SQLException {

        // Starts DB
        final Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        loadInitialData(connection);

        int serverPort = 8000;
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);

        final ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        HashMap<String, BasicRepository<?>> contexts = new HashMap<>();
        contexts.put("/api/availability", new AvailabilityRepository(connection));
        contexts.put("/api/collection_tool", new CollectionToolRepository(connection));
        contexts.put("/api/country", new CountryRepository(connection));
        contexts.put("/api/fish_area", new FishAreaRepository(connection));
        contexts.put("/api/format", new FormatRepository(connection));
        contexts.put("/api/hazard", new HazardRepository(connection));
        contexts.put("/api/hazard_type", new HazardTypeRepository(connection));
        contexts.put("/api/ind_sum", new IndSumRepository(connection));
        contexts.put("/api/laboratory_accreditation", new LaboratoryAccreditationRepository(connection));
        contexts.put("/api/language", new LanguageRepository(connection));
        contexts.put("/api/language_written_in", new LanguageWrittenInRepository(connection));
        contexts.put("/api/model_class", new ModelClassRepository(connection));
        contexts.put("/api/model_equation_class", new ModelEquationClassRepository(connection));
        contexts.put("/api/model_subclass", new ModelSubclassRepository(connection));
        contexts.put("/api/packaging", new PackagingRepository(connection));
        contexts.put("/api/parameter_distribution", new ParameterDistributionRepository(connection));
        contexts.put("/api/parameter_source", new ParameterSourceRepository(connection));
        contexts.put("/api/parameter_subject", new ParameterSubjectRepository(connection));
        contexts.put("/api/population", new PopulationRepository(connection));
        contexts.put("/api/product_matrix", new ProductMatrixRepository(connection));
        contexts.put("/api/product_treatment", new ProductTreatmentRepository(connection));
        contexts.put("/api/production_method", new ProductionMethodRepository(connection));
        contexts.put("/api/publication_status", new PublicationStatusRepository(connection));
        contexts.put("/api/publication_type", new PublicationTypeRepository(connection));
        contexts.put("/api/region", new RegionRepository(connection));
        contexts.put("/api/right", new RightRepository(connection));
        contexts.put("/api/sampling_method", new SamplingMethodRepository(connection));
        contexts.put("/api/sampling_point", new SamplingPointRepository(connection));
        contexts.put("/api/sampling_program", new SamplingProgramRepository(connection));
        contexts.put("/api/sampling_strategy", new SamplingStrategyRepository(connection));
        contexts.put("/api/software", new SoftwareRepository(connection));
        contexts.put("/api/source", new SourceRepository(connection));
        contexts.put("/api/status", new StatusRepository(connection));
        contexts.put("/api/unit", new UnitRepository(connection));
        contexts.put("/api/unit_category", new UnitCategoryRepository(connection));

        contexts.forEach((context, repository) -> server.createContext(context, new BasicHandler(mapper, repository)));
        server.setExecutor(null); // Creates a default executor
        server.start();
    }

    private static void loadInitialData(Connection connection) throws IOException {

        String dataFolder = Application.class.getResource("data/initialdata").getFile();
        
        Arrays.stream((new File(dataFolder)).listFiles()).forEach(file -> {
            try {
                System.out.println("Loading initial data: " + file.getName());
                String script = new String(Files.readAllBytes(file.toPath()));
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
            exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");

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
                try (OutputStream output = exchange.getResponseBody()) {
                    mapper.writeValue(output, repository.getAll());
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