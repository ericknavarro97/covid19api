package com.ericknavarro.covidapi.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto { //Data transfer Object - Patron de diseño
	
    @NotBlank(message = "El correo no puede ser nulo o vacío")
    @Email(message = "El correo debe ser válido")
    private String email;
    
    @NotBlank(message = "La contraseña es necesaria")
    private String contrasena;

}
