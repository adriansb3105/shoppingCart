package com.shoppingCart.dto;

import java.util.List;

public class User {
	
	private int id;
	private boolean isSuscribed;
	private String rol, firstName, lastName, login, password;
	private Address address;
	private List<Permission> permissions;
	private ContactInformation contactInformation;
	
	public User() {
		super();
	}
	public User(int id, boolean isSuscribed, String rol, String firstName, String lastName, String login,
			String password, Address address, List<Permission> permissions, ContactInformation contactInformation) {
		super();
		this.id = id;
		this.isSuscribed = isSuscribed;
		this.rol = rol;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.address = address;
		this.permissions = permissions;
		this.contactInformation = contactInformation;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isSuscribed() {
		return isSuscribed;
	}
	public void setSuscribed(boolean isSuscribed) {
		this.isSuscribed = isSuscribed;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	public ContactInformation getContactInformation() {
		return contactInformation;
	}
	public void setContactInformation(ContactInformation contactInformation) {
		this.contactInformation = contactInformation;
	}
	

}
