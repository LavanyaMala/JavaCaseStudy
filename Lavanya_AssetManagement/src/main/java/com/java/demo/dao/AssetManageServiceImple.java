package com.java.demo.dao;

import java.sql.Connection;
import com.java.model.Asset;
import com.java.model.MaintenanceRecord;
import com.java.myexceptions.AssetNotFoundException;
import com.java.myexceptions.AssetNotMaintainedException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.connect.DBConnUtil;

import com.java.model.Asset;
import java.util.ArrayList;
import java.util.Calendar;

public class AssetManageServiceImple implements  AssetManagementService {
	
	private Connection con;
	PreparedStatement stat;
	
	public AssetManageServiceImple()
	{
		con=DBConnUtil.getConnect();
		
	
	}
	
	
	

	@Override
	public boolean addAsset(Asset asset) {
		try
		{
	  stat=con.prepareStatement("insert into assets values(?,?,?,?,?,?,?,?)");
	  stat.setInt(1, asset.getAsset_id());
	  stat.setString(2, asset.getName());
	  stat.setString(3, asset.getType());
	  stat.setInt(4, asset.getSerial_number());
	  stat.setString(5, asset.getPurchase_date());
	  stat.setString(6,asset.getLocation());
	  stat.setString(7, asset.getStatus());
	  stat.setInt(8, asset.getOwner_id());
	  int rowsAffected = stat.executeUpdate();
	  if (rowsAffected > 0) {
          System.out.println("Asset inserted successfully");
          return true;
      } else {
          
          System.out.println("Asset is not inserted");
          return false;
      }
  } catch (Exception e) {
      
      System.out.println("Error deleting asset: " + e.getMessage());
      return false;
  } 
		
	}
	
	

	

	@Override
	public boolean updateAssets(Asset asset) {
	    try {
	        
	        String sql = "UPDATE assets SET name = ?, type = ?, serial_number = ?, purchase_date = ?, location = ?, status = ?, owner_id = ? WHERE asset_id = ?";
	        PreparedStatement stat = con.prepareStatement(sql);
	        
	       
	        stat.setString(1, asset.getName());
	        stat.setString(2, asset.getType());
	        stat.setInt(3, asset.getSerial_number());
	        stat.setString(4, asset.getPurchase_date());
	        stat.setString(5, asset.getLocation());
	        stat.setString(6, asset.getStatus());
	        stat.setInt(7, asset.getOwner_id());
	        stat.setInt(8, asset.getAsset_id());
	        
	        int rowsAffected = stat.executeUpdate();
	        
	        
	        if (rowsAffected > 0) {
	            System.out.println("Asset updated successfully");
	            return true;
	        } else {
	            System.out.println("Asset with ID " + asset.getAsset_id() + " not found");
	            return false;
	        }
	    } catch (SQLException e) {
	        System.out.println("Error updating asset: " + e.getMessage());
	        return false;
	    } finally {
	       
	        if (stat != null) {
	            try {
	                stat.close();
	            } catch (SQLException e) {
	                System.out.println("Error closing statement: " + e.getMessage());
	            }
	        }
	    }
	}

	



	@Override
	public boolean deleteAsset(int assetId) {
	    try {
	        
	        stat = con.prepareStatement("DELETE FROM assets WHERE asset_id = ?");
	        
	        
	        stat.setInt(1, assetId);
	        
	       
	        int rowsAffected = stat.executeUpdate();
	        
	        
	        if (rowsAffected > 0) {
	            System.out.println("Asset deleted successfully");
	            return true;
	        } else {
	            
	            System.out.println("No asset found with ID: " + assetId);
	            return false;
	        }
	    } catch (Exception e) {
	        
	        System.out.println("Error deleting asset: " + e.getMessage());
	        return false;
	    } 
	}

	@Override
	

		 public boolean allocateAsset(int assetId, int employeeId, String allocationDate) {
		        try {
		            
		            PreparedStatement statement = con.prepareStatement(
		                "INSERT INTO asset_allocations (asset_id, employee_id, allocation_date) VALUES (?, ?, ?)"
		            );
		            
		            
		            statement.setInt(1, assetId);
		            statement.setInt(2, employeeId);
		            statement.setString(3, allocationDate);

		           
		            int rowsAffected = statement.executeUpdate();

		           
		            if (rowsAffected > 0) {
		                System.out.println("Asset allocated successfully to employee " + employeeId + " on " + allocationDate);
		                return true; 
		            } else {
		                System.out.println("Failed to allocate asset.");
		                return false; 
		            }
		        } catch (Exception e) {
		            System.out.println("Error allocating asset: " + e.getMessage());
		            
		            return false; 
		        }
		    
		}

	@Override
	public boolean deallocateAsset(int assetId, int employeeId, String returnDate) {
		
		
		    try {
		        PreparedStatement stat = con.prepareStatement(
		            "UPDATE asset_allocations " +
		            "SET return_date = ? " +
		            "WHERE asset_id = ? AND employee_id = ? AND return_date IS NULL"
		        );

		        // Set parameters
		        stat.setString(1, returnDate);
		        stat.setInt(2, assetId);
		        stat.setInt(3, employeeId);

		        // Execute the update query
		        int rowsAffected = stat.executeUpdate();

		        if (rowsAffected > 0) {
		            System.out.println("Asset deallocated successfully");
		            return true; 
		        } else {
		            System.out.println("Asset deallocation failed. Asset may already be deallocated.");
		            return false; 
		        }
		    } catch (Exception e) {
		        System.out.println("Error deallocating asset: " + e.getMessage());
		        return false; 
		    }
		}


	


	@Override
	public boolean performMaintenance(int maintenanceId, int assetId, String maintenanceDate, String description, double cost) {
	    try {
	       
	        PreparedStatement statement = con.prepareStatement(
	            "INSERT INTO maintenance_records (maintenance_id, asset_id, maintenance_date, description, cost) VALUES (?, ?, ?, ?, ?)"
	        );

	        
	        statement.setInt(1, maintenanceId);
	        statement.setInt(2, assetId);
	        statement.setString(3, maintenanceDate);
	        statement.setString(4, description);
	        statement.setDouble(5, cost);

	        
	        int rowsAffected = statement.executeUpdate();

	        
	        if (rowsAffected > 0) {
	            System.out.println("Maintenance record added successfully.");
	            return true;
	        } else {
	            System.out.println("Failed to add maintenance record.");
	            return false;
	        }
	    } catch (SQLException e) {
	        System.out.println("Error adding maintenance record: " + e.getMessage());
	        return false;
	    }
	}



	

    


	@Override
	public boolean reserveAsset(int reservationId, int assetId, int employeeId, String reservationDate, String startDate, String endDate) {
	    try {
	        PreparedStatement stat = con.prepareStatement(
	            "INSERT INTO reservation (reservation_id, asset_id, employee_id, reservation_date, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)"
	        );

	        
	        stat.setInt(1, reservationId);
	        stat.setInt(2, assetId);
	        stat.setInt(3, employeeId);
	        stat.setString(4, reservationDate);
	        stat.setString(5, startDate);
	        stat.setString(6, endDate);
	        
	        
	        int rowsAffected = stat.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Reservation added successfully.");
	            return true;
	        } else {
	            System.out.println("Failed to add reservation.");
	            return false;
	        }
	    } catch (Exception e) {
	        System.out.println("Error adding reservation: " + e.getMessage());
	        return false;
	    }
	}


	@Override
	public boolean withdrawReservation(int reservationId) {
		
		    try {
		        PreparedStatement stat = con.prepareStatement(
		            "DELETE FROM reservation WHERE reservation_id = ?"
		        );

		       
		        stat.setInt(1, reservationId);

		        stat.executeUpdate();
		        
		        System.out.println("Withdraw reservation is succeessfull");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		
			return false;
		}




	@Override
	public boolean assetExists(int assetId) throws AssetNotFoundException {
		
        ResultSet rs = null;

        try {
            
           
            
            stat = con.prepareStatement("SELECT COUNT(*) FROM assets WHERE asset_id = ?");
            stat.setInt(1, assetId);

            
            rs = stat.executeQuery();

           
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    return true; 
                }
            }

           
            throw new AssetNotFoundException("Asset with ID " + assetId + " not found");
        } catch (SQLException e) {
            
            System.out.println("Error checking asset existence: " + e.getMessage());
            return false;
        } 
    }


	@Override
	public boolean assetMaintain(int assetId) throws AssetNotMaintainedException {
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	        
	        String sql = "SELECT MAX(maintenance_date) AS last_maintenance_date FROM maintenance_records WHERE asset_id = ?";
	        statement = con.prepareStatement(sql);
	        statement.setInt(1, assetId);

	        
	        resultSet = statement.executeQuery();

	        
	        Calendar maintenanceDate = null;
	        if (resultSet.next()) {
	            java.sql.Date lastMaintenanceDateSQL = resultSet.getDate("last_maintenance_date");
	            if (lastMaintenanceDateSQL != null) {
	                maintenanceDate = Calendar.getInstance();
	                //maintenanceDate.setTimeInMillis(lastMaintenanceDateSQL.getTime());

	                
	                Calendar currentDate = Calendar.getInstance();

	                
	                int diffInYears = currentDate.get(Calendar.YEAR) - maintenanceDate.get(Calendar.YEAR);

	                
	                if (diffInYears >= 2) {
	                    
	                    throw new AssetNotMaintainedException("Asset with ID " + assetId + " has not been maintained for 2 years.");
	                }
	            }
	        }

	        
	        return true;

	    } catch (SQLException e) {
	        
	        throw new AssetNotMaintainedException("Error checking maintenance status of asset with ID " + assetId);
	    } 
	}



	
}


	
	
	
	
	




	
	


