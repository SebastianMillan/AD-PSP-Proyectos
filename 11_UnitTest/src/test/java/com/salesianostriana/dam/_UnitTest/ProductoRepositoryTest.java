package com.salesianostriana.dam._UnitTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ProductoRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    ProductoRepository productoRepository;

    @Test
    void precioMenorQue(){
        Producto p1 = Producto.builder().precio(8).build();
        Producto p2 = Producto.builder().precio(10).build();
        Producto p3 = Producto.builder().precio(12).build();

        testEntityManager.persist(p1);
        testEntityManager.persist(p2);
        testEntityManager.persist(p3);
        List<Producto> resultado = productoRepository.findByPrecioLessThan(10);

        assertEquals(1, resultado.size());
        assertEquals(8, resultado.get(0).getPrecio());

    }
}
