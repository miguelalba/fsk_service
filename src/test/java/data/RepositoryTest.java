package data;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import domain.Availability;
import domain.CollectionTool;
import domain.Country;
import domain.FishArea;
import domain.Format;
import domain.Hazard;
import domain.HazardType;
import domain.LaboratoryAccreditation;
import domain.Language;
import domain.LanguageWrittenIn;
import domain.ModelClass;
import domain.ModelEquationClass;
import domain.ModelSubclass;
import domain.Packaging;
import domain.ParameterDistribution;
import domain.ParameterSource;
import domain.ParameterSubject;
import domain.Population;
import domain.ProductMatrix;
import domain.ProductTreatment;
import domain.ProductionMethod;
import domain.PublicationStatus;
import domain.PublicationType;
import domain.Region;
import domain.Right;
import domain.SamplingMethod;
import domain.SamplingPoint;
import domain.SamplingProgram;
import domain.SamplingStrategy;
import domain.Software;
import domain.Source;
import domain.Status;
import domain.Unit;
import domain.UnitCategory;

public class RepositoryTest {

	private static Connection connection;
	
	@ClassRule
	public static TemporaryFolder folder = new TemporaryFolder();

	@BeforeClass
	public static void setUp() throws SQLException, IOException {
		String databasePath = folder.getRoot().getAbsolutePath() + "/test";
		connection = DriverManager.getConnection("jdbc:h2:" + databasePath, "sa", "");

		// Load initial data
		String dataFolder = RepositoryTest.class.getResource("initialdata").getFile();
		
		File dataFolderFile = new File(dataFolder);
		Arrays.stream(dataFolderFile.listFiles()).forEach(file -> {
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

	@Test
	public void testAvailabilityEndpoints() throws SQLException {

		AvailabilityRepository repository = new AvailabilityRepository(connection);
		Availability[] availabilities = repository.getAll();
		assertTrue(availabilities.length > 0);

		int firstAvailabilityId = availabilities[0].getId();
		Availability firstAvailability = repository.getById(firstAvailabilityId);
		assertNotNull(firstAvailability);
	}

	@Test
	public void testFormatEndpoints() throws SQLException {

		FormatRepository repository = new FormatRepository(connection);
		Format[] formats = repository.getAll();
		assertTrue(formats.length > 0);

		int firstFormatId = formats[0].getId();
		Format firstFormat = repository.getById(firstFormatId);
		assertNotNull(firstFormat);
	}

	@Test
	public void testRightEndpoints() throws SQLException {

		RightRepository repository = new RightRepository(connection);
		Right[] rights = repository.getAll();
		assertTrue(rights.length > 0);

		int firstRightId = rights[0].getId();
		Right firstRight = repository.getById(firstRightId);
		assertNotNull(firstRight);
	}

	@Test
	public void testSourceEndpoints() throws SQLException {

		SourceRepository sourceRepository = new SourceRepository(connection);
		Source[] sources = sourceRepository.getAll();
		assertTrue(sources.length > 0);

		int firstSourceId = sources[0].getId();
		Source firstSource = sourceRepository.getById(firstSourceId);
		assertNotNull(firstSource);
	}

	@Test
	public void testPublicationTypeEndpoints() throws SQLException {

		PublicationTypeRepository repository = new PublicationTypeRepository(connection);
		PublicationType[] types = repository.getAll();
		assertTrue(types.length > 0);

		int firstTypeId = types[0].getId();
		PublicationType firstType = repository.getById(firstTypeId);
		assertNotNull(firstType);
	}

	@Test
	public void testPublicationStatusEndpoints() throws SQLException {

		PublicationStatusRepository repository = new PublicationStatusRepository(connection);
		PublicationStatus[] statuses = repository.getAll();
		assertTrue(statuses.length > 0);

		int firstStatusId = statuses[0].getId();
		PublicationStatus firstStatus = repository.getById(firstStatusId);
		assertNotNull(firstStatus);
	}

	@Test
	public void testLanguageEndpoints() throws SQLException {

		LanguageRepository repository = new LanguageRepository(connection);
		Language[] languages = repository.getAll();
		assertTrue(languages.length > 0);

		int firstLanguageId = languages[0].getId();
		Language firstLanguage = repository.getById(firstLanguageId);
		assertNotNull(firstLanguage);
	}

	@Test
	public void testSoftwareEndpoints() throws SQLException {

		SoftwareRepository repository = new SoftwareRepository(connection);
		Software[] softwares = repository.getAll();
		assertTrue(softwares.length > 0);

		int firstSoftwareId = softwares[0].getId();
		Software firstSoftware = repository.getById(firstSoftwareId);
		assertNotNull(firstSoftware);
	}

	@Test
	public void testLanguageWrittenInEndpoints() throws SQLException {

		LanguageWrittenInRepository repository = new LanguageWrittenInRepository(connection);
		LanguageWrittenIn[] languages = repository.getAll();
		assertTrue(languages.length > 0);

		int firstLanguageId = languages[0].getId();
		LanguageWrittenIn firstLanguage = repository.getById(firstLanguageId);
		assertNotNull(firstLanguage);
	}

	@Test
	public void testUnitCategoryEndpoints() throws SQLException {

		UnitCategoryRepository repository = new UnitCategoryRepository(connection);
		UnitCategory[] categories = repository.getAll();
		assertTrue(categories.length > 0);

		int firstCategoryId = categories[0].getId();
		UnitCategory firstCategory = repository.getById(firstCategoryId);
		assertNotNull(firstCategory);
	}

	@Test
	public void testHazardTypeEndpoints() throws SQLException {

		HazardTypeRepository repository = new HazardTypeRepository(connection);
		HazardType[] types = repository.getAll();
		assertTrue(types.length > 0);

		int firstTypeId = types[0].getId();
		HazardType firstType = repository.getById(firstTypeId);
		assertNotNull(firstType);
	}

	@Test
	public void testProductMatrixEndpoints() throws SQLException {

		ProductMatrixRepository repository = new ProductMatrixRepository(connection);
		ProductMatrix[] matrices = repository.getAll();
		assertTrue(matrices.length > 0);

		int firstMatrixId = matrices[0].getId();
		ProductMatrix firstMatrix = repository.getById(firstMatrixId);
		assertNotNull(firstMatrix);
	}

	@Test
	public void testProductionMethodEndpoints() throws SQLException {

		ProductionMethodRepository repository = new ProductionMethodRepository(connection);
		ProductionMethod[] methods = repository.getAll();
		assertTrue(methods.length > 0);

		int firstMethodId = methods[0].getId();
		ProductionMethod firstMethod = repository.getById(firstMethodId);
		assertNotNull(firstMethod);
	}

	@Test
	public void testPackagingEndpoints() throws SQLException {

		PackagingRepository repository = new PackagingRepository(connection);
		Packaging[] packagings = repository.getAll();
		assertTrue(packagings.length > 0);

		int firstPackagingId = packagings[0].getId();
		Packaging firstPackaging = repository.getById(firstPackagingId);
		assertNotNull(firstPackaging);
	}

	@Test
	public void testProductTreatmentEndpoints() throws SQLException {

		ProductTreatmentRepository repository = new ProductTreatmentRepository(connection);
		ProductTreatment[] treatments = repository.getAll();
		assertTrue(treatments.length > 0);

		int firstTreatmentId = treatments[0].getId();
		ProductTreatment firstTreatment = repository.getById(firstTreatmentId);
		assertNotNull(firstTreatment);
	}

	@Test
	public void testRegionEndpoints() throws SQLException {

		RegionRepository repository = new RegionRepository(connection);
		Region[] regions = repository.getAll();
		assertTrue(regions.length > 0);

		int firstRegionId = regions[0].getId();
		Region firstRegion = repository.getById(firstRegionId);
		assertNotNull(firstRegion);
	}

	@Test
	public void testFishAreaEndpoints() throws SQLException {

		FishAreaRepository repository = new FishAreaRepository(connection);
		FishArea[] areas = repository.getAll();
		assertTrue(areas.length > 0);

		int firstAreaId = areas[0].getId();
		FishArea firstArea = repository.getById(firstAreaId);
		assertNotNull(firstArea);
	}

	@Test
	public void testHazardEndpoints() throws SQLException {

		HazardRepository repository = new HazardRepository(connection);
		Hazard[] hazards = repository.getAll();
		assertTrue(hazards.length > 0);

		int firstHazardId = hazards[0].getId();
		Hazard firstHazard = repository.getById(firstHazardId);
		assertNotNull(firstHazard);
	}

	@Test
	public void testCountryEndpoints() throws SQLException {

		CountryRepository repository = new CountryRepository(connection);
		Country[] countries = repository.getAll();
		assertTrue(countries.length > 0);

		int firstCountryId = countries[0].getId();
		Country firstCountry = repository.getById(firstCountryId);
		assertNotNull(firstCountry);
	}

	@Test
	public void testPopulationEndpoints() throws SQLException {

		PopulationRepository repository = new PopulationRepository(connection);
		Population[] populations = repository.getAll();
		assertTrue(populations.length > 0);

		int firstPopulationId = populations[0].getId();
		Population firstPopulation = repository.getById(firstPopulationId);
		assertNotNull(firstPopulation);
	}

	@Test
	public void testSamplingMethodEndpoints() throws SQLException {

		SamplingMethodRepository repository = new SamplingMethodRepository(connection);
		SamplingMethod[] methods = repository.getAll();
		assertTrue(methods.length > 0);

		int firstMethodId = methods[0].getId();
		SamplingMethod firstMethod = repository.getById(firstMethodId);
		assertNotNull(firstMethod);
	}

	@Test
	public void testSamplingPointEndpoints() throws SQLException {

		SamplingPointRepository repository = new SamplingPointRepository(connection);
		SamplingPoint[] points = repository.getAll();
		assertTrue(points.length > 0);

		int firstPointId = points[0].getId();
		SamplingPoint firstPoint = repository.getById(firstPointId);
		assertNotNull(firstPoint);
	}

	@Test
	public void testParameterSourceEndpoints() throws SQLException {

		ParameterSourceRepository repository = new ParameterSourceRepository(connection);
		ParameterSource[] sources = repository.getAll();
		assertTrue(sources.length > 0);

		int firstSourceId = sources[0].getId();
		ParameterSource firstSource = repository.getById(firstSourceId);
		assertNotNull(firstSource);
	}

	@Test
	public void testParameterSubjectEndpoints() throws SQLException {

		ParameterSubjectRepository repository = new ParameterSubjectRepository(connection);
		ParameterSubject[] subjects = repository.getAll();
		assertTrue(subjects.length > 0);

		int firstSubjectId = subjects[0].getId();
		ParameterSubject firstSubject = repository.getById(firstSubjectId);
		assertNotNull(firstSubject);
	}

	@Test
	public void testModelEquationClassEndpoints() throws SQLException {

		ModelEquationClassRepository repository = new ModelEquationClassRepository(connection);
		ModelEquationClass[] classes = repository.getAll();
		assertTrue(classes.length > 0);

		int firstClassId = classes[0].getId();
		ModelEquationClass firstClass = repository.getById(firstClassId);
		assertNotNull(firstClass);
	}

	@Test
	public void testSamplingStrategyEndpoints() throws SQLException {

		SamplingStrategyRepository repository = new SamplingStrategyRepository(connection);
		SamplingStrategy[] strategies = repository.getAll();
		assertTrue(strategies.length > 0);

		int firstStrategyId = strategies[0].getId();
		SamplingStrategy firstStrategy = repository.getById(firstStrategyId);
		assertNotNull(firstStrategy);
	}

	@Test
	public void testSamplingProgramEndpoints() throws SQLException {

		SamplingProgramRepository repository = new SamplingProgramRepository(connection);
		SamplingProgram[] programs = repository.getAll();
		assertTrue(programs.length > 0);

		int firstProgramId = programs[0].getId();
		SamplingProgram firstProgram = repository.getById(firstProgramId);
		assertNotNull(firstProgram);
	}

	@Test
	public void testLaboratoryAccreditationEndpoints() throws SQLException {

		LaboratoryAccreditationRepository repository = new LaboratoryAccreditationRepository(connection);
		LaboratoryAccreditation[] accreditations = repository.getAll();
		assertTrue(accreditations.length > 0);

		int firstAccreditationId = accreditations[0].getId();
		LaboratoryAccreditation firstAccreditation = repository.getById(firstAccreditationId);
		assertNotNull(firstAccreditation);
	}

	@Test
	public void testParameterDistributionEndpoints() throws SQLException {

		ParameterDistributionRepository repository = new ParameterDistributionRepository(connection);
		ParameterDistribution[] distributions = repository.getAll();
		assertTrue(distributions.length > 0);

		int firstDistributionId = distributions[0].getId();
		ParameterDistribution firstDistribution = repository.getById(firstDistributionId);
		assertNotNull(firstDistribution);
	}

	@Test
	public void testCollectionToolEndpoints() throws SQLException {

		CollectionToolRepository repository = new CollectionToolRepository(connection);
		CollectionTool[] tools = repository.getAll();
		assertTrue(tools.length > 0);

		int firstToolId = tools[0].getId();
		CollectionTool firstTool = repository.getById(firstToolId);
		assertNotNull(firstTool);
	}

	@Test
	public void testIndSumEndpoints() throws SQLException {

		IndSumRepository repository = new IndSumRepository(connection);
		IndSum[] sums = repository.getAll();
		assertTrue(sums.length > 0);

		int firstSumId = sums[0].getId();
		IndSum firstSum = repository.getById(firstSumId);
		assertNotNull(firstSum);
	}

	@Test
	public void testUnitEndpoints() throws SQLException {

		UnitRepository repository = new UnitRepository(connection);
		Unit[] units = repository.getAll();
		assertTrue(units.length > 0);

		int firstUnitId = units[0].getId();
		Unit firstUnit = repository.getById(firstUnitId);
		assertNotNull(firstUnit);
	}

	@Test
	public void testStatusEndpoints() throws SQLException {

		StatusRepository repository = new StatusRepository(connection);
		Status[] statuses = repository.getAll();
		assertTrue(statuses.length > 0);

		int firstStatusId = statuses[0].getId();
		Status firstStatus = repository.getById(firstStatusId);
		assertNotNull(firstStatus);
	}

	@Test
	public void testModelClassEndpoints() throws SQLException {

		ModelClassRepository repository = new ModelClassRepository(connection);
		ModelClass[] classes = repository.getAll();
		assertTrue(classes.length > 0);

		int firstClassId = classes[0].getId();
		ModelClass firstClass = repository.getById(firstClassId);
		assertNotNull(firstClass);
	}

	@Test
	public void testModelSubclassEndpoints() throws SQLException {

		ModelSubclassRepository repository = new ModelSubclassRepository(connection);
		ModelSubclass[] subclasses = repository.getAll();
		assertTrue(subclasses.length > 0);

		int firstClassId = subclasses[0].getId();
		ModelSubclass firstClass = repository.getById(firstClassId);
		assertNotNull(firstClass);
	}
}
