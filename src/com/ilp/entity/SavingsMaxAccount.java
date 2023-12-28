package com.ilp.entity;

import java.util.ArrayList;

public class SavingsMaxAccount extends Product {
	

	public SavingsMaxAccount(String productCode, String productName, ArrayList<Service> serviceList) {
		super(productCode, productName, serviceList);
		this.minimumBalance = 1000;
	}

	

	@Override
	public String toString() {
		
		return super.toString()+"SavingsMaxAccount [minimumBalance=" + minimumBalance + "]";
	}



	private double minimumBalance;

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		if (this.minimumBalance >= 1000)
		this.minimumBalance = minimumBalance;
		else 
			System.out.println("Minimum Balance must be greater than 1000");
		
	}



}
