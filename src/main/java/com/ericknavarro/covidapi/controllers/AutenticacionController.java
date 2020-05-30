package com.ericknavarro.covidapi.controllers;

import java.util.Calendar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericknavarro.covidapi.dao.UsuarioRepository;
import com.ericknavarro.covidapi.dto.LoginDto;
import com.ericknavarro.covidapi.dto.TokenDto;
import com.ericknavarro.covidapi.error.UnauthorizedException;
import com.ericknavarro.covidapi.models.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/autenticacion")
@AllArgsConstructor
public class AutenticacionController {
	
	private UsuarioRepository repository;
	
	@PostMapping
	public ResponseEntity<?> authenticate(@Valid @RequestBody LoginDto loginDto){
		
		Usuario usuario = repository.findByEmailAndContrasena(loginDto.getEmail(), loginDto.getContrasena());
		
		if(usuario != null) {
			
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.HOUR, 1);
			
			String jwt = Jwts.builder() //Genera el token para el cliente
					.setSubject(usuario.getEmail())
					.claim("role", "user")
					.setExpiration(calendar.getTime())
					.signWith(SignatureAlgorithm.HS256, "123456").compact();
			
			TokenDto tokenDto = new TokenDto(jwt);
			
			return new ResponseEntity<>(tokenDto, HttpStatus.OK);
			
		} else{
                    throw new UnauthorizedException();
                }
                
                /*else {
			
			MessageDto messageDto = new MessageDto("Error", "Correo o contraseña incorrectos");
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(messageDto);
		}*/
		
	}


}
