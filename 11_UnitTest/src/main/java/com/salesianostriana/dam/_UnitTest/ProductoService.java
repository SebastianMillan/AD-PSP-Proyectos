package com.salesianostriana.dam._UnitTest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    //Se deberá de usar DTO aunque en este ejemplo no se haga
    public Producto save(Producto p){
        return productoRepository.save(p);
    }

    public List<Producto> saveAll(List<Producto> lista){
        return productoRepository.saveAll(lista);
    }

    public List<Producto> findAll(){
        return productoRepository.findAll();
    }

    public List<Producto> precioMenorQue10(){
        return productoRepository.findByPrecioLessThan(10);
    }

    public List<GetProductoDto> precioMenorQue10YDisponible(){
        List<Producto> todos = findAll();
        List<GetProductoDto> resultado = new ArrayList<>();

        for(Producto p : todos){
            if(p.getPrecio()<10){
                if(p.isDisponible()){
                    resultado.add(GetProductoDto.of(p));
                }
            }
        }
        if(resultado.isEmpty()){
            return null;
        }else{
            return resultado;
        }
    }
}
