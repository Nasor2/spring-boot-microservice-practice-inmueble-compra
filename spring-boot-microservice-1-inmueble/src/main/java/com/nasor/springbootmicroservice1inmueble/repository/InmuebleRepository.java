package com.nasor.springbootmicroservice1inmueble.repository;

import com.nasor.springbootmicroservice1inmueble.model.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {

}
