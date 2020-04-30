package com.ericknavarro.covidapi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericknavarro.covidapi.models.Equipamiento;
import com.ericknavarro.covidapi.models.Hospital;
import com.ericknavarro.covidapi.service.EquipamientoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/${api.version}/equipamientos")
@AllArgsConstructor
public class EquipamientoController {

	private EquipamientoService service;
	
	@GetMapping
	public ResponseEntity<List<Equipamiento>> findAllEquipamientos() {
		return new ResponseEntity<>(service.findAllEquipamientos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Equipamiento> findEquipamientoById(@PathVariable("id") Integer equipamientoId) {
		return new ResponseEntity<>(service.findEquipamientoById(equipamientoId), HttpStatus.OK);
	}
	
	@PostMapping("/{id}/hospitales")
	public ResponseEntity<Equipamiento> addHospitalToEquipamiento(@PathVariable("id") Integer equipamientoId, @RequestBody Hospital hospital){
		return new ResponseEntity<Equipamiento>(service.addHospitalToEquipamiento(equipamientoId, hospital.getHospitalId()), HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Equipamiento> saveEquipamiento(@RequestBody Equipamiento equipamiento) {
		return new ResponseEntity<>(service.saveEquipamiento(equipamiento), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Equipamiento> updateEquipamiento(@PathVariable("id") Integer equipamientoId, @RequestBody Equipamiento equipamiento) {
		return new ResponseEntity<>(service.updateEquipamiento(equipamientoId, equipamiento), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEquipamiento(@PathVariable("id") Integer equipamientoId) {
		service.deleteEquipamiento(equipamientoId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
