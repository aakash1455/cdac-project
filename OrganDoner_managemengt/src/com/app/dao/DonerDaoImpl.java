package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.app.pojos.Doner;

import java.util.List;

import org.hibernate.*;

@Repository
public class DonerDaoImpl implements IDonerDao 
{
	// dependency
	@Autowired // byType
	private SessionFactory sf;

	public DonerDaoImpl() 
	{
		System.out.println("in cnstr of " + getClass().getName());
	}

	@Override
	public Doner validateUser(String email, String pass)
	{
		String jpql = "select d from Doner d where d.email=:em and d.password=:pa";
		return sf.getCurrentSession().createQuery(jpql, Doner.class).setParameter("em", email).setParameter("pa", pass)
				.getSingleResult();
	}

	@Override
	public List<Doner> listDoners() 
	{
		String jpql = "select d from Doner d where d.role=:role";
		return sf.getCurrentSession().
				createQuery(jpql, Doner.class).
				setParameter("role", "doner").getResultList();
	}

	@Override
	public String deleteDonerDetails(Doner d)
	{
		//v --detached pojo ref
		sf.getCurrentSession().delete(d);
		return "Doner details deleted for Doner ID "+d.getId();
	}

	@Override
	public String updateDonerDetails(Doner d) 
	{
		
		sf.getCurrentSession().update(d);
		return "Doner details updated for Donerr ID "+d.getId();
	}

	@Override
	public String registerDoner(Doner d) 
	{
		sf.getCurrentSession().persist(d); 
		return "Doner details insertedd for Doner ID "+d.getId();
	}

	@Override
	public Doner getDonerDetails(int did) 
	{
		return sf.getCurrentSession().get(Doner.class, did);
	}
	

}
