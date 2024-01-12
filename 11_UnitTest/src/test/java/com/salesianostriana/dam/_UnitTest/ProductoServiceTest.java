package com.salesianostriana.dam._UnitTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest -> Sería una test de integración
@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {

    @Mock //crea un doble
    ProductoRepository productoRepository;

    @InjectMocks //se instancia de verdad, pero las dependencias serán mocks
    ProductoService productoService;

    @Test
    void precioMenorQue10YDisponible() {

        List<Producto> data = List.of(
                new Producto(1L, "P1", 9.99, true),
                new Producto(2L, "P2", 10, true),
                new Producto(3L, "P3", 33, true),
                new Producto(4L, "P4", 15, false),
                new Producto(5L, "P5", 9.99, false),
                new Producto(6L, "P6", 12, true)
                );

        // Precondiciones
        Mockito.when(productoRepository.findAll()).thenReturn(data);

        // Test
        List<GetProductoDto> expectedResult = List.of(new GetProductoDto(1L, "P1"));
        List<GetProductoDto> result = productoService.precioMenorQue10YDisponible();

        assertEquals(expectedResult, result);
    }

}