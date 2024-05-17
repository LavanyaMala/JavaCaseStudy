import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AssetCreationTest {

    // Initialize your necessary objects for testing (e.g., database connection, DAO)
    private AssetDAO assetDAO;
    private Connection connection;

    @Before
    public void setUp() throws Exception {
        // Set up your test environment (e.g., initialize database connection, create DAO)
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
        assetDAO = new AssetDAO(connection);
    }

    @After
    public void tearDown() throws Exception {
        // Clean up resources after each test (e.g., close database connection)
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testAssetCreation() {
        try {
            // Create a new asset
            Asset asset = new Asset();
            asset.setName("Test Asset");
            asset.setDescription("This is a test asset");

            // Add the asset to the database
            assetDAO.addAsset(asset);

            // Retrieve the asset from the database by its ID
            Asset retrievedAsset = assetDAO.getAssetById(asset.getId());

            // Assert that the retrieved asset is not null
            assertNotNull("Retrieved asset should not be null", retrievedAsset);
            
            // Assert that the retrieved asset's name matches the expected name
            assertEquals("Test Asset", retrievedAsset.getName());

            // Assert that the retrieved asset's description matches the expected description
            assertEquals("This is a test asset", retrievedAsset.getDescription());
        } catch (Exception e) {
            // If any exception occurs, fail the test
            e.printStackTrace();
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
