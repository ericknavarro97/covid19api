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
import com.ericknavarro.covidapi.service.HospitalService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/${api.version}/hospitales")
@AllArgsConstructor
public class HospitalController {
	
	private HospitalService service;
	
	@GetMapping
	public ResponseEntity<List<Hospital>> findAllHospital() {
		return new ResponseEntity<>(service.findAllHospital(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hospital> findAllHospitalById(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(service.findHospitalById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Hospital> saveHospital(@RequestBody Hospital hospital) {
		return new ResponseEntity<>(service.saveHospital(hospital), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Hospital> updateHospital(@PathVariable("id") Integer id, @RequestBody Hospital hospital) {
		return new ResponseEntity<>(service.updateHospital(id, hospital), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteHospital(@PathVariable("id") Integer id) {
		service.deleteHospitalById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/{id}/equipamientos")
	public ResponseEntity<List<Equipamiento>> findAllEquipamientoHospitalById(@PathVariable("id") Integer hospitalId){
		return new ResponseEntity<List<Equipamiento>>(service.findHospitalById(hospitalId).getEquipamientos(), HttpStatus.OK);
	}
	
	
}
