package com.java.model;

public class Asset {
	int asset_id;
	String Name;
	String type;
	int serial_number;
	String purchase_date;
	String location;
	String status;
	int owner_id;
	public Asset(int asset_id, String type, int serial_number, String location, String status, int owner_id, String Name, String purchase_date) {
		super();
		this.asset_id = asset_id;
		this.Name = Name;
		this.type = type;
		this.serial_number = serial_number;
		this.purchase_date = purchase_date;
		this.location = location;
		this.status = status;
		this.owner_id = owner_id;
	}
	public Asset() {
		// TODO Auto-generated constructor stub
	}
	public Asset(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}
	public int getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(int serial_number) {
		this.serial_number = serial_number;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}
	@Override
	public String toString() {
		return "Asset [asset_id=" + asset_id + ", Name=" + Name + ", type=" + type + ", serial_number=" + serial_number
				+ ", purchase_date=" + purchase_date + ", location=" + location + ", status=" + status + ", owner_id="
				+ owner_id + "]";
	}
	
	
}
