package com.example.WebService;

public class car {
	public String plateNumber;
	public String brand;
	public int price;
	public Boolean rented;
	public Dates date; 
	
	public car() {
		super();
	}
	
	public car(String plateNumber, String brand, int price, Boolean rented , Dates _date) {
		super();
		this.plateNumber = plateNumber;
		this.brand = brand;
		this.price = price;
		this.rented = rented;
		this.date = _date;
	}
	
	public String getPlateNumber() {
		return plateNumber;
	}
	
	public String getPlateNumber(String plateNumber) {
		return plateNumber;
	}
	
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Boolean getRented() {
		return rented;
	}
	public Dates getDate() {
		return date;
	}
	public void setDate(String debut , String fin) {
		this.date.setBegin(debut) ; 
		this.date.setEnd(fin) ; 
	}
	
	@Override
	public String toString() {
		return "Car [plateNumber=" + plateNumber + ", brand=" + brand + ", price=" + price + ", rent=" + rented +", date=" + date.toString() +"]";
	}

}