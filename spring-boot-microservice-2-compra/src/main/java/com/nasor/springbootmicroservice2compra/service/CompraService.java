package com.nasor.springbootmicroservice2compra.service;

import com.nasor.springbootmicroservice2compra.model.Compra;

import java.util.List;

public interface CompraService {

    Compra saveCompra(Compra compra);

    List<Compra> findAllByUserId(Long userId);
}
