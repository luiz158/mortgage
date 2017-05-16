package com.mercury.tests;

import java.util.List;

import com.mercury.mc.persistence.model.CalculationResult;
import com.mercury.mc.service.Calculator;

public class Test02 {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		double principal = 300000;
		int type = 3;
		String state = "NJ";
		double extraPayment = 2000;
		int extraMonth = 6;
		double monthRate = cal.getMonthRate(type, state);
		List<CalculationResult> list = cal.calculate(principal, type, monthRate, extraPayment, extraMonth);
		System.out.println(cal.originalPayment(principal, 180, monthRate));
		System.out.println("year \t month \t payment \t extraPay \t totalPay \t balance");
		for (int i = 0; i < 12; i++) {
			System.out.println(list.get(i));
		}
		for (int i = 168; i < 180; i++) {
			System.out.println(list.get(i));
		}
		int totalMonth = list.size();
		double savedInterest = cal.originalPayment(principal, totalMonth, monthRate) - list.get(totalMonth - 1).getTotalPayment();
		savedInterest = (int)(100 * savedInterest) / 100.0;
		System.out.println(savedInterest);
	}
}
