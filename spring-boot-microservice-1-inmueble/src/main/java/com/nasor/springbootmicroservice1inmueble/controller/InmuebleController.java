package com.nasor.springbootmicroservice1inmueble.controller;

import com.nasor.springbootmicroservice1inmueble.model.Inmueble;
import com.nasor.springbootmicroservice1inmueble.service.InmuebleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/inmueble")
public class InmuebleController {

    private final InmuebleService inmuebleService;

    public InmuebleController(InmuebleService inmuebleService) {
        this.inmuebleService = inmuebleService;
    }

    @PostMapping
    public ResponseEntity<Inmueble> saveInmueble(@RequestBody Inmueble inmueble){

        Inmueble savedInmueble = inmuebleService.saveInmueble(inmueble);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedInmueble.getId()).toUri();

        return ResponseEntity.created(location).body(savedInmueble);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInmueble(@PathVariable Long id){
        inmuebleService.deleteInmuebleById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Inmueble>> findAllInmuebles(){
        return ResponseEntity.ok(inmuebleService.findAllInmuebles());
    }
}
