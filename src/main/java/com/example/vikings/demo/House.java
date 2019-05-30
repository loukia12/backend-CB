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
	
	private int price, size;
	private String contact, location, status, image;
	
	public House() {
		
	}
	
	public House(int price, int size, String status, String contact, String location, String image) {
		super();
		this.price = price;
		this.size = size;
		this.status = status;
		this.contact = contact;
		this.location = location;
		this.image = image;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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

	public String getImage() {
		return image;
	}

	public void setImage(String imageURL) {
		this.image = imageURL;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", price=" + price + ", size=" + size + ", contact=" + contact + ", location="
				+ location + ", status=" + status + ", image=" + image + "]";
	}	
}

