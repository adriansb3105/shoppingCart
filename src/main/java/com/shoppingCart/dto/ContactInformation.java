package com.shoppingCart.dto;

public class ContactInformation {
	
	private int id;
	private String phone1, phone2, fax;
	
	public ContactInformation(int id, String phone1, String phone2, String fax) {
		super();
		this.id = id;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.fax = fax;
	}
	public ContactInformation() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}


}
