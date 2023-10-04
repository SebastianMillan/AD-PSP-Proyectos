package com.salesianostriana.dam.EjercicioDTOPareja.controller;

import com.salesianostriana.dam.EjercicioDTOPareja.dto.GetProductoDto;
import com.salesianostriana.dam.EjercicioDTOPareja.model.Producto;
import com.salesianostriana.dam.EjercicioDTOPareja.model.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoRepository productoRepository;

    @GetMapping("/")
    public ResponseEntity<List<GetProductoDto>> getTodos(){

        List<Producto> lista = productoRepository.findAll();

        if(lista.isEmpty())
            return ResponseEntity.notFound().build();

        List<GetProductoDto> resutls = lista.stream()
                .map(GetProductoDto::of)
                .toList();

        return ResponseEntity.ok(resutls);
    }
}
