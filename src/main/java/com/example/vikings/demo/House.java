package com.example.vikings.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "houses")
public class House {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int price, size, status;
	private String contact, location;
	
	public House() {
		
	}
	
	public House(int price, int size, int status, String contact, String location) {
		super();
		this.price = price;
		this.size = size;
		this.status = status;
		this.contact = contact;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", price=" + price + ", size=" + size + ", status=" + status + ", contact=" + contact
				+ ", location=" + location + "]";
	}

}
