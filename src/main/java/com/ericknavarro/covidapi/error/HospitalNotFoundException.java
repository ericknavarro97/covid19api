/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ericknavarro.covidapi.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *∫
 * @author ericknavarro
 */

@Getter
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class HospitalNotFoundException extends RuntimeException {
    
    private final Integer hospitalId;
    
    public HospitalNotFoundException(Integer hospitalId){
        super(String.format("Hospital con el id %d", hospitalId));
        this.hospitalId = hospitalId;
    }
    
}
