package com.java.demo.dao;

import java.sql.SQLException;
import java.util.Calendar;

import com.java.model.Asset;
import com.java.myexceptions.AssetNotFoundException;
import com.java.myexceptions.AssetNotMaintainedException;

public interface AssetManagementService<calender> {
	boolean addAsset(Asset asset);
	boolean updateAssets(Asset asset);
	boolean deleteAsset(int assetId);
	boolean allocateAsset(int assetId,int employeeId,String allocationDate);
	boolean deallocateAsset(int assetId,int employeeId,String returnDate);
	boolean performMaintenance(int maintenance_id,int assetId, String maintenanceDate, String Description,double cost);
	boolean reserveAsset(int reservationId,int assetId,int employeeId,String reservationDate,String startDate,String endDate);
	boolean withdrawReservation(int reservationId);
	boolean assetExists(int assetId) throws AssetNotFoundException;
	boolean assetMaintain(int assetId) throws AssetNotMaintainedException;
	
	
	}
	
    

