package com.eriicknavarro.covidapi.service;

import java.util.List;

import com.ericknavarro.covidapi.models.Hospital;

public interface HospitalService  {
	
	List<Hospital> findAllHospital();
	
	Hospital findHospitalById(Integer hospitalId);
	
	Hospital saveHospital(Hospital hospital);
	
	Hospital updateHospital(Integer hospitalId, Hospital hospital);
	
	void deleteHospitalById(Integer hospitalId);
	
}
