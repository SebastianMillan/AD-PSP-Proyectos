package com.salesianostriana.dam._EjercicioAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository monumentoRepository;

    @GetMapping("/monumento/")
    public ResponseEntity<Object> getAll(){
        List<Monumento> resultado = monumentoRepository.findAll();

        if(resultado.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/monumento/{id}")
    public ResponseEntity<Monumento> findById(@PathVariable Long id){
        return ResponseEntity.of(monumentoRepository.findById(id));
    }

    @PostMapping("/monumento/")
    public ResponseEntity<Monumento> create(@RequestBody Monumento monumento){
        Monumento nuevo = monumentoRepository.save(monumento);
        return ResponseEntity.status(201).body(nuevo);
    }

    /*
    @PutMapping("/monumento/{id}")
    public ResponseEntity<Monumento> edit(@RequestBody Monumento monumento, @PathVariable Long id){
        return ResponseEntity.of(monumentoRepository.findById(id)
                .map(antiguo -> {
                    antiguo.setDescripcion(monumento.getDesc);
                        }

                )

        );
    }
     */

    @DeleteMapping("/monumento/{id}")
    public ResponseEntity<?> delete(@RequestBody Monumento monumento, @PathVariable Long id){
        if(monumentoRepository.existsById(id))
            monumentoRepository.delete(monumento);

        return ResponseEntity.noContent().build();
    }
}
