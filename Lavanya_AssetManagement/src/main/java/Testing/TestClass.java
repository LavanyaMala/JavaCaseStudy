package Testing;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import com.java.demo.dao.AssetManagementService;
import com.java.model.Asset;


public class TestClass {
	
	

	    private AssetManagementService service;
	    private Asset testAsset;

	    @Before
	    public void setUp() {
	        // Initialize the service and any necessary dependencies
	        service = new AssetManagementService();
	        // Create a test asset object with sample data
	        testAsset = new Asset();
	        testAsset.setName("Test Asset");
	        testAsset.setType("Test Type");
	        testAsset.setSerial_number("123456789");
	        testAsset.setPurchase_date("2024-05-17");
	        testAsset.setLocation("Test Location");
	        testAsset.setStatus("Active");
	        testAsset.setOwner_id(1); // Sample owner ID
	    }

	    @Test
	    public void testAssetCreation() {
	        // Attempt to create the asset
	        boolean created = service.addAsset(testAsset);
	        assertTrue("Asset creation failed", created);
	    }
	}



