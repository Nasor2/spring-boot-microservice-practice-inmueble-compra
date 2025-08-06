package com.nasor.springbootmicroservicec3apigateway.controller;

import com.nasor.springbootmicroservicec3apigateway.request.InmuebleServiceRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/gateway/inmueble")
public class InmuebleController {

    private final InmuebleServiceRequest inmuebleServiceRequest;

    public InmuebleController(InmuebleServiceRequest inmuebleServiceRequest) {
        this.inmuebleServiceRequest = inmuebleServiceRequest;
    }

    @PostMapping
    public ResponseEntity<?> saveInmueble(@RequestBody Object inmueble){
        return new ResponseEntity<>(inmuebleServiceRequest.saveInmueble(inmueble), HttpStatus.CREATED);
    }

    @DeleteMapping("/{imuebleId}")
    public ResponseEntity<?> deleteInmueble(@PathVariable("imuebleId") Long imuebleId){
        inmuebleServiceRequest.deleteInmueble(imuebleId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> findAllInmuebles(){
        return ResponseEntity.ok(inmuebleServiceRequest.findAllInmuebles());
    }

}
