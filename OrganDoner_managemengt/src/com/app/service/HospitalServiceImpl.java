package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.Hospitaldaoimpl;
import com.app.dao.IHospitalDao;
import com.app.pojos.Hospital;
@Service 
@Transactional 
public class HospitalServiceImpl implements IHospitalServices 
{

	@Autowired
	private Hospitaldaoimpl dao;
	@Override
	public Hospital validateHospital(String hospitalName, String password) 
	{
		
		return dao.validateHospital(hospitalName, password);
	}

}
