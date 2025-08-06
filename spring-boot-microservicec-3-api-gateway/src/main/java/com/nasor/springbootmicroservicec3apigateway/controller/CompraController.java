package com.nasor.springbootmicroservicec3apigateway.controller;

import com.nasor.springbootmicroservicec3apigateway.request.CompraServiceRequest;
import com.nasor.springbootmicroservicec3apigateway.security.UserPrincipal;
import feign.Body;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gateway/compra")
public class CompraController {

    private final CompraServiceRequest compraServiceRequest;

    public CompraController(CompraServiceRequest compraServiceRequest) {
        this.compraServiceRequest = compraServiceRequest;
    }

    @PostMapping
    public ResponseEntity<?> saveCompra(@RequestBody Object compra) {
        return new ResponseEntity<>(compraServiceRequest.saveCompra(compra), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getComprasOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return ResponseEntity.ok(compraServiceRequest.getComprasOfUser(userPrincipal.getId()));
    }

}
