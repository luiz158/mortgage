package com.mercury.tests;

import java.util.List;

import com.mercury.mc.persistence.model.CalculationResult;
import com.mercury.mc.service.Calculator;

public class Test02 {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		double principal = 300000;
		int type = 1;
		String state = "NJ";
		double extraPayment = 2000;
		int extraMonth = 6;
		List<CalculationResult> list = cal.calculate(principal, type, state, extraPayment, extraMonth);
		System.out.println("year \t month \t payment \t extraPay \t totalPay \t balance");
		for (int i = 0; i < 12; i++) {
			System.out.println(list.get(i));
		}
		for (int i = 348; i < 360; i++) {
			System.out.println(list.get(i));
		}
	}
}
