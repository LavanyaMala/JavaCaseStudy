package com.java.model;

public class AssetAllocation {
	int allocation_id;
	int asset_id;
	int employee_id;
	String allocation_date;
	String return_date;
	public AssetAllocation(int allocation_id, int asset_id, int employee_id, String allocation_date,
			String return_date) {
		super();
		this.allocation_id = allocation_id;
		this.asset_id = asset_id;
		this.employee_id = employee_id;
		this.allocation_date = allocation_date;
		this.return_date = return_date;
	}
	public int getAllocation_id() {
		return allocation_id;
	}
	public void setAllocation_id(int allocation_id) {
		this.allocation_id = allocation_id;
	}
	public int getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getAllocation_date() {
		return allocation_date;
	}
	public void setAllocation_date(String allocation_date) {
		this.allocation_date = allocation_date;
	}
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	@Override
	public String toString() {
		return "AssetAllocation [allocation_id=" + allocation_id + ", asset_id=" + asset_id + ", employee_id="
				+ employee_id + ", allocation_date=" + allocation_date + ", return_date=" + return_date + "]";
	}

}
