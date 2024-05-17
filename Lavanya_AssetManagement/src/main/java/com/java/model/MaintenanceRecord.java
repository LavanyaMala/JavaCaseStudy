package com.java.model;

public class MaintenanceRecord {
	int maintenance_id;
	int asset_id;
	String maintenance_date;
	String description;
	double cost;
	public MaintenanceRecord(int maintenance_id, int asset_id, String maintenance_date, String description, double cost) {
		super();
		this.maintenance_id = maintenance_id;
		this.asset_id = asset_id;
		this.maintenance_date = maintenance_date;
		this.description = description;
		this.cost = cost;
	}
	public MaintenanceRecord() {
		// TODO Auto-generated constructor stub
	}
	public int getMaintenance_id() {
		return maintenance_id;
	}
	public void setMaintenance_id(int maintenance_id) {
		this.maintenance_id = maintenance_id;
	}
	public int getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
	}
	public String getMaintenance_date() {
		return maintenance_date;
	}
	public void setMaintenance_date(String maintenance_date) {
		this.maintenance_date = maintenance_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	
	@Override
	public String toString() {
		return "MaintenanceRecord [maintenance_id=" + maintenance_id + ", asset_id=" + asset_id + ", maintenance_date="
				+ maintenance_date + ", description=" + description + ", cost=" + cost + "]";
	}
	
}
