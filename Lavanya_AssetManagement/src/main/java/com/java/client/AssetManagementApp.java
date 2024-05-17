package com.java.client;

import com.java.demo.service.AssetService;
import com.java.model.Asset;
import com.java.myexceptions.AssetNotFoundException;
import com.java.demo.dao.AssetManageServiceImple;
import com.java.demo.dao.AssetManagementService;

import java.util.ArrayList;
import java.util.Scanner;

public class AssetManagementApp {
   

	public static void main(String[] args) throws AssetNotFoundException {
    	
        Scanner scanner = new Scanner(System.in);
        
        
        AssetManagementService assetManagementService = new AssetManageServiceImple();
        
        
        AssetService assetService = new AssetService(assetManagementService);
        
        
        
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add Asset");
            System.out.println("2. Update Asset");
            System.out.println("3. Delete Asset");
            System.out.println("4. Allocate Asset");
            System.out.println("5. Deallocate Asset");
            System.out.println("6. Maintenance the record of the Asset");
            System.out.println("7. Reserve the asset");
            System.out.println("8. Withdraw an asset");
            
           
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
            case 1:
                assetService.addAsset();
                break;
                
            case 2:
            			
                        assetService.updateAsset();
                        break;
                        
            case 3:
            			assetService.deleteAssets();
            			break;
            			
            case 4:
            			assetService.allocateAssets();
            			break;
            			
            case 5:
            			assetService.deallocateAssets();
            			break;
            	
            	
            case 6:
            			assetService.performMaintenances();
            			break;
            			
            	
            case 7:
            			assetService.reserveAssets();
            			break;
            			
            case 8:
            			assetService.withdrawAssets();
            			break;
            			
                    
         
            
            case 0:
                
                break;
                
            default:
                System.out.println("Invalid option. Please try again.");
        }

        }
        
        
    }

	
	
}
