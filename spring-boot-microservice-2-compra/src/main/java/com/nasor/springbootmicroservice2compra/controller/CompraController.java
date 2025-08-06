package com.nasor.springbootmicroservice2compra.controller;

import com.nasor.springbootmicroservice2compra.model.Compra;
import com.nasor.springbootmicroservice2compra.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/compra")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public ResponseEntity<Compra> saveCompra(@RequestBody Compra compra) {
        Compra compraSaved = compraService.saveCompra(compra);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(compraSaved.getId()).toUri();

        return ResponseEntity.created(location).body(compraSaved);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Compra>> findAll(@PathVariable Long userId) {
        return ResponseEntity.ok().body(compraService.findAllByUserId(userId));
    }
}
