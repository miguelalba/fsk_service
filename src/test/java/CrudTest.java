import domain.Availability;
import domain.Format;
import domain.Right;
import domain.Source;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CrudTest {

    private static Crud crud;

    @BeforeClass
    public static void setUp() throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:h2:./test", "sa", "");
        crud = new Crud(connection);
    }

    @AfterClass
    public static void tearDown() throws IOException {
        Files.delete(Paths.get("test.mv.db")); // Remove test DB
    }

    @Test
    public void testAvailabilityEndpoints() throws SQLException {

        Availability[] availabilities = crud.getAvailabilities();
        assertTrue(availabilities.length > 0);

        String firstAvailabilityId = availabilities[0].getId();
        Availability firstAvailability = crud.getAvailability(firstAvailabilityId);
        assertNotNull(firstAvailability);
    }

    @Test
    public void testFormatEndpoints() throws SQLException {

        Format[] formats = crud.getFormats();
        assertTrue(formats.length > 0);

        String firstFormatId = formats[0].getId();
        Format firstFormat = crud.getFormat(firstFormatId);
        assertNotNull(firstFormat);
    }

    @Test
    public void testRightEndpoints() throws SQLException {

        Right[] rights = crud.getRights();
        assertTrue(rights.length > 0);

        String firstRightId = rights[0].getId();
        Right firstRight = crud.getRight(firstRightId);
        assertNotNull(firstRight);
    }

    @Test
    public void testSourceEndpoints() throws SQLException {

        Source[] sources = crud.getSources();
        assertTrue(sources.length > 0);

        int firstSourceId = sources[0].getId();
        Source firstSource = crud.getSource(firstSourceId);
        assertNotNull(firstSource);
    }

}