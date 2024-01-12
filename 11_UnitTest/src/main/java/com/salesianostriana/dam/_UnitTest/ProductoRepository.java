package com.salesianostriana.dam._UnitTest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {


    List<Producto> findByPrecioLessThan(double precio);

}