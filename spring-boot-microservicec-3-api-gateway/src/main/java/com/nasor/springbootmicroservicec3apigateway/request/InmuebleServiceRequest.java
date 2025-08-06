package com.nasor.springbootmicroservicec3apigateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        value = "inmueble-service",
        path = "/api/v1/inmueble",
       // url = "${inmueble.service.url}",
        configuration = FeingConfiguration.class
)
public interface InmuebleServiceRequest {
    @PostMapping
    Object saveInmueble(@RequestBody Object request);

    @DeleteMapping("/{inmuebleId}")
    void deleteInmueble(@PathVariable("inmuebleId") Long inmuebleId);

    @GetMapping()
    List<Object> findAllInmuebles();
}
