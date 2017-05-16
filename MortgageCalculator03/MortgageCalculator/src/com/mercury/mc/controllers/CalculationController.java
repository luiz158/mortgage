package com.mercury.mc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mercury.mc.persistence.model.CalculationResult;
import com.mercury.mc.persistence.model.CalculationResultDisplay;
import com.mercury.mc.service.Calculator;

@Controller
@RequestMapping("/json")
public class CalculationController {
	@RequestMapping(value="{principal}/{type}/{state}/{extraPayment}/{extraMonth}", method=RequestMethod.GET)
	public @ResponseBody CalculationResultDisplay getResultInJson(@PathVariable double principal, @PathVariable int type, @PathVariable String state, @PathVariable double extraPayment, @PathVariable int extraMonth) {
		Calculator cal = new Calculator();
		double monthRate = cal.getMonthRate(type, state);
		List<CalculationResult> list = cal.calculate(principal, type, monthRate, extraPayment, extraMonth);
		int totalMonth = list.size();
		int totalYear = totalMonth / 12;
		double payment = list.get(0).getPayment();
		double savedInterest = cal.originalPayment(principal, totalMonth, monthRate) - list.get(totalMonth - 1).getTotalPayment();
		savedInterest = (int)(100 * savedInterest) / 100.0;
		return new CalculationResultDisplay(list, principal, totalYear, payment, savedInterest);
		//return new CalculationResultDisplay();
	}
	
//	public @ResponseBody List<CalculationResult> getResultInJson(@PathVariable double principal, @PathVariable int type, @PathVariable String state, @PathVariable double extraPayment, @PathVariable int extraMonth) {
//		Calculator cal = new Calculator();
//		double monthRate = cal.getMonthRate(type, state);
//		List<CalculationResult> list = cal.calculate(principal, type, monthRate, extraPayment, extraMonth);
//		return list;
//	}
//	@RequestMapping(value="{principal}/{type}/{state}/{extraPayment}/{extraMonth}", method=RequestMethod.GET)
//	public @ResponseBody String getUserInJson(@PathVariable double principal, @PathVariable int type, @PathVariable String state, @PathVariable double extraPayment, @PathVariable int extraMonth) {
//		return "Hello!";
//	}
	/*@RequestMapping(value="{name}", method=RequestMethod.GET)
	public @ResponseBody String getUserInJson(@PathVariable String name) {
		return "hello!";
	}*/
}
