package com.ericknavarro.covidapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericknavarro.covidapi.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByEmailAndContrasena(String email, String contrasena);

}
