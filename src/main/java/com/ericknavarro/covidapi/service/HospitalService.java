package com.ericknavarro.covidapi.service;

import java.util.List;

import com.ericknavarro.covidapi.models.Hospital;
import java.util.Optional;

public interface HospitalService  {
	
	List<Hospital> findAllHospital();
	
	Optional<Hospital> findHospitalById(Integer hospitalId);
	
	Hospital saveHospital(Hospital hospital);
	
	Hospital updateHospital(Integer hospitalId, Hospital hospital);
	
	void deleteHospitalById(Integer hospitalId);
	
}
