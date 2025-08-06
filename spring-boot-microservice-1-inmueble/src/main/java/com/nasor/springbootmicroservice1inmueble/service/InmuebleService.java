package com.nasor.springbootmicroservice1inmueble.service;

import com.nasor.springbootmicroservice1inmueble.model.Inmueble;

import java.util.List;

public interface InmuebleService {
    Inmueble saveInmueble(Inmueble inmueble);

    void deleteInmuebleById(Long id);

    List<Inmueble> findAllInmuebles();
}
