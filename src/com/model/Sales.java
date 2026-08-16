package com.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Sales {
	private int salesId;
	private LocalDate saleDate;
	private LocalTime saleTime;
	private int employeeId;
	
	public int getSalesId() {
		return salesId;
	}
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}
	public LocalDate getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}
	public LocalTime getSaleTime() {
		return saleTime;
	}
	public void setSaleTime(LocalTime saleTime) {
		this.saleTime = saleTime;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	
	public void generateSale() {
		setEmployeeId(employeeId);
		setSaleDate(LocalDate.now());
		setSaleTime(LocalTime.now()); 
	}
}
