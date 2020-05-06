package com.ericknavarro.covidapi.dto;

import lombok.Data;

@Data
public class LoginDto { //Data transfer Object - Patron de diseño
	
	private String email;
	private String contrasena;

}
