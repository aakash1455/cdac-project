package com.app.dao;


import com.app.pojos.Hospital;

public interface IHospitalDao 
{

	Hospital validateHospital(String hospitalName,String password);
}
