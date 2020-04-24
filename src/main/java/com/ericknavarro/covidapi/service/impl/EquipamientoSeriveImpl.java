package com.ericknavarro.covidapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ericknavarro.covidapi.dao.EquipamientoRepository;
import com.ericknavarro.covidapi.models.Equipamiento;
import com.ericknavarro.covidapi.service.EquipamientoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EquipamientoSeriveImpl implements EquipamientoService {
	
	private EquipamientoRepository repository;

	@Override
	public List<Equipamiento> findAllEquipamientos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Equipamiento findEquipamientoById(Integer equipamientoId) {
		// TODO Auto-generated method stub
		return repository.getOne(equipamientoId);
	}

	@Override
	public Equipamiento saveEquipamiento(Equipamiento equipamiento) {
		// TODO Auto-generated method stub
		return repository.save(equipamiento);
	}

	@Override
	public Equipamiento updateEquipamiento(Integer equipamientoId, Equipamiento equipamiento) {
		// TODO Auto-generated method stub
		
		Equipamiento equipamientoDB = findEquipamientoById(equipamientoId);
		
		equipamientoDB.setDescripcion(equipamiento.getDescripcion());
		equipamientoDB.setCantidad(equipamiento.getCantidad());
		equipamientoDB.setNombre(equipamiento.getNombre());
		equipamientoDB.setFechaVencimiento(equipamiento.getFechaVencimiento());
		equipamientoDB.setFechaCreacion(equipamiento.getFechaCreacion());
		
		
		return saveEquipamiento(equipamientoDB);
	}

	@Override
	public void deleteEquipamiento(Integer equipamientoId) {
		// TODO Auto-generated method stub
		
	}

}
