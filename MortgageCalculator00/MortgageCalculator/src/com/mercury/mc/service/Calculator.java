package com.mercury.mc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.common.db.Dao;
import com.mercury.mc.persistence.model.CalculationResult;

public class Calculator {
	public List<CalculationResult> calculate(double principal, int type, String state, double extraPayment, int extraMonth) {
		List<CalculationResult> list = new ArrayList<CalculationResult>();
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		Dao dao = (Dao)ac.getBean("hdb");
		double yearRate = dao.findInterest(state, type);
		double monthRate = (yearRate / 12) / 100;
		int totalYear;
		if (type == 2) {
			totalYear = 20;
		} else if (type == 3) {
			totalYear = 15;
		} else {
			totalYear = 30;
		}
		int totalMonth = totalYear * 12;
		double temp1 = Math.pow((1 + monthRate), totalMonth);
		double temp2 = Math.pow((1 + monthRate), (totalMonth - extraMonth));
		double payment;
		payment = principal * monthRate * temp1 / (temp1 - 1) - extraPayment * (temp1 - temp2) / (temp1 - 1);
		int countMonth = 0;
		double totalPayment = 0.0;
		double balance = principal;
		for (int year = 1; year <= totalYear; year++) {
			for (int month = 1; month <= 12; month++) {
				countMonth ++;
				totalPayment += payment;
				balance = balance * (1 + monthRate) - payment;
				double extraPay = 0.0;
				if (countMonth <= extraMonth) {
					extraPay = extraPayment;
					totalPayment += extraPayment;
					balance = balance - extraPayment;
				}
				CalculationResult cr = new CalculationResult(year, month, 
						(int)(100 * payment) / 100.0, extraPay, (int)(100 * totalPayment) / 100.0, (int)(100 * balance) / 100.0);
				list.add(cr);
			}
		}	
		return list;
	}
}
