package com.ericknavarro.covidapi.service;

import java.util.List;

import com.ericknavarro.covidapi.models.Equipamiento;

public interface EquipamientoService {
	
	List<Equipamiento> findAllEquipamientos();
	
	Equipamiento findEquipamientoById(Integer equipamientoId);
	
	Equipamiento saveEquipamiento(Equipamiento equipamiento);
	
	Equipamiento updateEquipamiento(Integer equipamientoId, Equipamiento equipamiento);
	
	void deleteEquipamiento(Integer equipamientoId);

}
