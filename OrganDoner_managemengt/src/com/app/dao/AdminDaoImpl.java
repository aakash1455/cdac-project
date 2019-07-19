package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.app.pojos.Admin;

import java.util.List;

import org.hibernate.*;

@Repository
public class AdminDaoImpl implements IAdminDao 
{

	@Autowired 
	private SessionFactory sf;
	
	public AdminDaoImpl()
	{
		System.out.println("in cnstr of " + getClass().getName());
	}
	@Override
	public Admin validateAdmin(String name, String password)
	{
		
		String jpql = "select d from Admin d where d.name=:em and d.password=:pa";
		return sf.getCurrentSession().createQuery(jpql, Admin.class).setParameter("em", name).setParameter("pa", password)
				.getSingleResult();
	}


}
