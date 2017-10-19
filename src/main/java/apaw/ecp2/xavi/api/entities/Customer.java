package apaw.ecp2.xavi.api.entities;

import java.util.Calendar;

public class Customer {
	private int id;
	private String name;
	private String address;
	private Calendar date;
	private Account account;
	
	public Customer(String name) {
		assert name != null;
		this.name = name;
	}
	
	public Customer (int id) {
		assert id > 0;
		this.id = id;
	}
	
	public Customer (int id, String name) {
		assert id > 0;
		assert name != null;
		this.id = id;
		this.name = name;
	}
	
	public Customer (int id, String name, String address, Calendar date, Account account) {
		assert id > 0;
		assert name != null;
		assert address != null;
		assert date != null;
		assert account != null;
		
		this.id = id;
		this.name = name;
		this.address = address;
		this.date = date;
		this.account = account;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public Calendar getDate() {
		return this.date;
	}
	
	public Account getAccount() {
		return this.account;
	}
	
	public void setId (int id) {
		assert id > 0;
		this.id = 0;
	}
	
	public void setName (String name) {
		assert name != null;
		this.name = name;
	}
	
	public void setAddress (String address) {
		assert address != null;
		this.address = address;
	}
	
	public void setDate (Calendar date) {
		assert date != null;
		this.date = date;
	}
	
	public void setAccount (Account account) {
		assert account != null;
		this.account = account;
	}
}
