package com.mercury.common.db;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class HibernateDao implements Dao {
	private HibernateTemplate template;
	private String[] mortgageType = {"fix_30", "fix_20", "fix_15", "arm_5", "arm_7", "arm_10"};
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public double findInterest(String state, int type) {
		String typeString = mortgageType[type - 1];
		String hql = "select i." + typeString + " from Interest as i where i.state = '" + state + "'";
		return (Double) template.find(hql).get(0);
	}

}
