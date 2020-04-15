package data;

import domain.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RepositoryTest {

    private static Connection connection;

    @BeforeClass
    public static void setUp() throws SQLException, IOException {
        connection = DriverManager.getConnection("jdbc:h2:./test", "sa", "");

        // Load initial data
        String dataFolder = RepositoryTest.class.getResource("initialdata").getFile();

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

    @AfterClass
    public static void tearDown() throws IOException {
        Files.delete(Paths.get("test.mv.db")); // Remove test DB
    }

    @Test
    public void testAvailabilityEndpoints() throws SQLException {

        AvailabilityRepository repository = new AvailabilityRepository(connection);
        Availability[] availabilities = repository.getAll();
        assertTrue(availabilities.length > 0);

        String firstAvailabilityId = availabilities[0].getId();
        Availability firstAvailability = repository.getById(firstAvailabilityId);
        assertNotNull(firstAvailability);
    }

    @Test
    public void testFormatEndpoints() throws SQLException {

        FormatRepository repository = new FormatRepository(connection);
        Format[] formats = repository.getAll();
        assertTrue(formats.length > 0);

        String firstFormatId = formats[0].getId();
        Format firstFormat = repository.getById(firstFormatId);
        assertNotNull(firstFormat);
    }

    @Test
    public void testRightEndpoints() throws SQLException {

        RightRepository repository = new RightRepository(connection);
        Right[] rights = repository.getAll();
        assertTrue(rights.length > 0);

        String firstRightId = rights[0].getId();
        Right firstRight = repository.getById(firstRightId);
        assertNotNull(firstRight);
    }

    @Test
    public void testSourceEndpoints() throws SQLException {

        SourceRepository sourceRepository = new SourceRepository(connection);
        Source[] sources = sourceRepository.getAll();
        assertTrue(sources.length > 0);

        String firstSourceId = Integer.toString(sources[0].getId());
        Source firstSource = sourceRepository.getById(firstSourceId);
        assertNotNull(firstSource);
    }

    @Test
    public void testPublicationTypeEndpoints() throws SQLException {

        PublicationTypeRepository repository = new PublicationTypeRepository(connection);
        PublicationType[] types = repository.getAll();
        assertTrue(types.length > 0);

        String firstTypeId = types[0].getId();
        PublicationType firstType = repository.getById(firstTypeId);
        assertNotNull(firstType);
    }

    @Test
    public void testPublicationStatusEndpoints() throws SQLException {

        PublicationStatusRepository repository = new PublicationStatusRepository(connection);
        PublicationStatus[] statuses = repository.getAll();
        assertTrue(statuses.length > 0);

        String firstStatusId = statuses[0].getId();
        PublicationStatus firstStatus = repository.getById(firstStatusId);
        assertNotNull(firstStatus);
    }
}
