package com.ericknavarro.covidapi.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericknavarro.covidapi.dao.UsuarioRepository;
import com.ericknavarro.covidapi.models.Usuario;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {
	
	private UsuarioRepository repository;
	
	@PostMapping
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
		usuario.setCreateAt(new Date());
		return new ResponseEntity<Usuario>(repository.save(usuario), HttpStatus.CREATED);
	}

}
