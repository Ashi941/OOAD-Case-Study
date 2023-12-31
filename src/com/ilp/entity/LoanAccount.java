package com.ilp.entity;

import java.util.ArrayList;

public class LoanAccount extends Product{
	

	public LoanAccount(String productCode, String productName, ArrayList<Service> serviceList) {
		super(productCode, productName, serviceList);
		this.chequeDeposit = 0.3;
	}

	@Override
	public String toString() {
		return "LoanAccount [chequeDeposit=" + chequeDeposit + "]";
	}

	private double chequeDeposit;

	public double getChequeDeposit() {
		return chequeDeposit;
	}

	public void setChequeDeposit(double chequeDeposit) {
		this.chequeDeposit = chequeDeposit;
	}

}

