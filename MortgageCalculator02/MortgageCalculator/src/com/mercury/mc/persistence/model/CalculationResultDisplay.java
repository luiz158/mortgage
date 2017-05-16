package com.mercury.mc.persistence.model;

import java.util.List;

public class CalculationResultDisplay {
	private List<CalculationResult> list;
	private double principal;
	private int totalYear;
	private double payment;
	private double savedInterest;
	
	public CalculationResultDisplay() {}
	public CalculationResultDisplay(List<CalculationResult> list, double principal, int totalYear, double payment, double savedInterest) {
		this.list = list;
		this.principal = principal;
		this.totalYear = totalYear;
		this.payment = payment;
		this.savedInterest = savedInterest;
	}
	public List<CalculationResult> getList() {
		return list;
	}
	public void setList(List<CalculationResult> list) {
		this.list = list;
	}
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public int getTotalYear() {
		return totalYear;
	}
	public void setTotalYear(int totalYear) {
		this.totalYear = totalYear;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public double getSaveInterest() {
		return savedInterest;
	}
	public void setSaveInterest(double savedInterest) {
		this.savedInterest = savedInterest;
	}
}
