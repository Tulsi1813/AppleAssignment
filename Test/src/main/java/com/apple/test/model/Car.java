package com.apple.test.model;

public class Car {

	String make;
	String model;
	String vin;
	Metadata data;
	Perdayrent rent;
	Metrics metrics;
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public Metadata getData() {
		return data;
	}
	public void setData(Metadata data) {
		this.data = data;
	}
	public Perdayrent getRent() {
		return rent;
	}
	public void setRent(Perdayrent rent) {
		this.rent = rent;
	}
	public Metrics getMetrics() {
		return metrics;
	}
	public void setMetrics(Metrics metrics) {
		this.metrics = metrics;
	}
	
	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", vin=" + vin + ", data=" + data + ", rent=" + rent
				+ ", metrics=" + metrics + "]";
	}
}
