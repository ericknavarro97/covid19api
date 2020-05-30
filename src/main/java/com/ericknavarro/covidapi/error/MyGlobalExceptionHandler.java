/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ericknavarro.covidapi.error;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author ericknavarro
 */

@ControllerAdvice
public class MyGlobalExceptionHandler extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler(UnauthorizedException.class)
    public void handleNotFoundException(HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
             
}
