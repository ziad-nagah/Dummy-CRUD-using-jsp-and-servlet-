package com.item.model;

public class Item {
	
	private int id;
	
	private String name;
	
	private double price;
	
	private int totalNumber;
	
	private String detail;
	

	public Item() {
		
	}
public Item(int id , String detail) {
	this.id =id;
	this.detail = detail;

	}
	public Item(String name, double price, int totalNumber , String detail ) {
		this.name = name;
		this.price = price;
		this.totalNumber = totalNumber;
		this.detail = detail;
	}
	
	public Item(int id, String name, double price, int totalNumber , String detail ) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.totalNumber = totalNumber;
		this.detail = detail;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}

