package rs.engineering.javacourse.springMvcConfiguration02.dto;

import java.io.Serializable;

public class Company implements Serializable {
	private String name;
	private String address;
	public Company() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ", address=" + address + "]";
	}
	public Company(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	

}
