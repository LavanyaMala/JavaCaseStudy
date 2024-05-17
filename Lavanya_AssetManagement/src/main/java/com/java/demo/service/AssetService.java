package com.java.demo.service;

import com.java.model.Asset;
import com.java.myexceptions.AssetNotFoundException;
import com.java.myexceptions.AssetNotMaintainedException;
import com.java.demo.dao.AssetManagementService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AssetService {
    private Scanner sc;
    private AssetManagementService ser;

    public AssetService(AssetManagementService ser) {
        sc = new Scanner(System.in);
        this.ser = ser;
    }

    public void addAsset() {
    	try {
        Asset as = new Asset();
        System.out.println("Enter the asset ID:");
        as.setAsset_id(sc.nextInt());
        sc.nextLine(); 
        System.out.println("Enter the name:");
        as.setName(sc.nextLine());
        System.out.println("Enter the type of asset:");
        as.setType(sc.nextLine());
        System.out.println("Enter the serial number:");
        as.setSerial_number(sc.nextInt());
        sc.nextLine(); 
        System.out.println("Enter the purchase date:");
        as.setPurchase_date(sc.nextLine());
        System.out.println("Enter the location:");
        as.setLocation(sc.nextLine());
        System.out.println("Enter the status:");
        as.setStatus(sc.nextLine());
        System.out.println("Enter the Owner ID:");
        as.setOwner_id(sc.nextInt());
        System.out.println("Inserted Successfully");
        ser.addAsset(as);
    }
    	catch (Exception e) {
            System.out.println("Error in inserting asset: " + e.getMessage());
        }
    	
    }

    public void updateAsset() {
        try {
            Asset as = new Asset();
            System.out.println("Enter the asset ID:");
            int assetId = sc.nextInt();
            sc.nextLine(); 
            as.setAsset_id(assetId); 

            if (!ser.assetExists(assetId)) {
                throw new AssetNotFoundException("Asset with ID " + assetId + " does not exist.");
            }

            
            System.out.println("Enter the name:");
            as.setName(sc.nextLine());
            System.out.println("Enter the type:");
            as.setType(sc.nextLine());
            System.out.println("Enter the serial number:");
            as.setSerial_number(sc.nextInt());
            sc.nextLine(); // Consume newline character
            System.out.println("Enter the purchase date:");
            as.setPurchase_date(sc.nextLine());
            System.out.println("Enter the location:");
            as.setLocation(sc.nextLine());
            System.out.println("Enter the status:");
            as.setStatus(sc.nextLine());
            System.out.println("Enter the owner ID:");
            as.setOwner_id(sc.nextInt());

           
            ser.updateAssets(as);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data types.");
            sc.nextLine(); 
        } catch (AssetNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }



	public void deleteAssets() {
        try {
            System.out.println("Enter the asset ID:");
            int assetId = sc.nextInt();
            ser.deleteAsset(assetId);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data types.");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Error deleting asset: " + e.getMessage());
        }
    }
    public void allocateAssets()
    {
    	try {
    	System.out.println("Enter the asset ID:");
        int assetId = sc.nextInt();
        System.out.println("Enter the Employee ID:");
        int employeeId = sc.nextInt();
        System.out.println("Enter the allocation date:");
        sc.nextLine();
        String allocationDate = sc.nextLine();
        ser.allocateAsset (assetId,employeeId,allocationDate);
    	}
    	catch (Exception e) {
            System.out.println("Error deleting asset: " + e.getMessage());
        }
    		
    	}
    	
    

	
    public void deallocateAssets()

    {
    	try {
    		System.out.println("Enter the asset ID:");
    		int assetId = sc.nextInt();
    		System.out.println("Enter the Employee ID:");
    		int employeeId = sc.nextInt();
    		System.out.println("Enter the returnDate:");
    		sc.nextLine();
    		String returnDate = sc.nextLine();
    		ser.deallocateAsset(assetId,employeeId,returnDate);
    	}
    	catch (Exception e) {
    		System.out.println("Error: " + e.getMessage());
    	}
		
	}


public void performMaintenances() {
    try {
        System.out.println("Enter the asset ID:");
        int assetId = sc.nextInt();
        sc.nextLine();
       
        if (!ser.assetMaintain(assetId)) {
            System.out.println("Asset with ID " + assetId + " has not been maintained for 2 years.");
            return; 
        }
        
        
        System.out.println("Enter the maintenance ID:");
        int maintenanceId = sc.nextInt();
        sc.nextLine();
        
        
        System.out.println("Enter the maintenance date:");
        String maintenanceDate = sc.nextLine();
        System.out.println("Enter the description:");
        String description = sc.nextLine();
        System.out.println("Enter the cost:");
        double cost = sc.nextDouble();
        sc.nextLine();
       
        if (cost < 0) {
            System.out.println("Cost must be a positive number.");
            return;
        }
        
        if (ser.performMaintenance(maintenanceId, assetId, maintenanceDate, description, cost)) {
            System.out.println("Maintenance record added successfully.");
        } else {
            System.out.println("Failed to add maintenance record.");
        }
        
    } catch (InputMismatchException e) {
        System.out.println("Invalid input");
        sc.nextLine(); 
    } catch (AssetNotMaintainedException e) {
        System.out.println(e.getMessage());
    } catch (Exception e) {
        System.out.println("Error occurred: " + e.getMessage());
    }
}




public void reserveAssets()

{
	try {
	System.out.println("Enter the reseration Id:");
	int reservationId = sc.nextInt();
	System.out.println("Enter the asset ID:");
    int assetId = sc.nextInt();
    System.out.println("Enter the employee Id:");
    int employeeId = sc.nextInt();
    System.out.println("Enter the reservationDate:");
    sc.nextLine();
    String reservationDate = sc.nextLine();
    System.out.println("Enter the startDate");
    String startDate = sc.nextLine();
    System.out.println("Enter the endDate");
    String endDate = sc.nextLine();
    ser.reserveAsset(reservationId,assetId,employeeId,reservationDate,startDate,endDate );
	}
	catch (Exception e) {
        System.out.println("Error deleting asset: " + e.getMessage());
    }
		
	}
	


public void withdrawAssets() {
    try {
        
        System.out.println("Enter the reservation Id:");
        int reservationId = sc.nextInt();
        
        
        ser.withdrawReservation(reservationId);
    }
    catch (Exception e) {
        System.out.println("Error deleting asset: " + e.getMessage());
    }
}
}
    

        
