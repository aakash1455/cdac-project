package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Admin;
import com.app.pojos.Hospital;

@Repository
public class Hospitaldaoimpl implements IHospitalDao 
{

	@Autowired 
	private SessionFactory sf;
	
	public Hospitaldaoimpl()
	{
		System.out.println("in cnstr of " + getClass().getName());
	}
	@Override
	public Hospital validateHospital(String hospitalName, String password)
	{
		System.out.println("name is:: "+hospitalName);
		System.out.println("password is:: "+password);
		
		String jpql = "select h from Hospital h where h.hospitalName=:em and h.password=:pa";
		return sf.getCurrentSession().createQuery(jpql, Hospital.class).setParameter("em", hospitalName).setParameter("pa", password)
				.getSingleResult();
	}

}
