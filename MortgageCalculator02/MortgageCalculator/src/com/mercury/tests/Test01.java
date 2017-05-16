package com.mercury.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.common.db.Dao;

public class Test01 {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		Dao dao = (Dao)ac.getBean("hdb");
		System.out.println(dao.findInterest("NJ", 1));
	}
}
