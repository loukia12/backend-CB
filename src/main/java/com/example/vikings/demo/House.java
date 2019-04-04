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
	
	private int price;
	private int size;
	
	public House() {
		
	}

	public House(int id, int price, int size) {
		super();
		this.id = id;
		this.price = price;
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "House [id=" + id + ", price=" + price + ", size=" + size + "]";
	}

}
