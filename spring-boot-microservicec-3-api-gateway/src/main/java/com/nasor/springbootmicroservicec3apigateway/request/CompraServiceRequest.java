package com.nasor.springbootmicroservicec3apigateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        value = "compra-service",
        path = "/api/v1/compra",
      //  url = "${compras.servicce.url}",
        configuration = FeingConfiguration.class
)
public interface CompraServiceRequest {

    @PostMapping
    Object saveCompra(@RequestBody Object compra);

    @GetMapping("/{userId}")
    List<Object> getComprasOfUser(@PathVariable("userId") Long userId);
}
