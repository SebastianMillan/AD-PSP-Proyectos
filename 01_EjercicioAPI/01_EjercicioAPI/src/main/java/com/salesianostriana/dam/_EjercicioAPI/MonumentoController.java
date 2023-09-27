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
    public ResponseEntity<List<Monumento>> getAll(){
        List<Monumento> lista = monumentoRepository.findAll();
        if(lista.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/monumento/{id}")
    public ResponseEntity<Monumento> findById(@PathVariable Long id){
        return ResponseEntity.of(monumentoRepository.findById(id));
    }

    @PostMapping("/monumento/")
    public ResponseEntity<Monumento> create(@RequestBody Monumento monumento){
        Monumento monumentoNuevo = monumentoRepository.save(monumento);
        return ResponseEntity.status(201).body(monumentoNuevo);
    }

    @PutMapping
    public ResponseEntity<Monumento> edit (@RequestBody Monumento monumento, @PathVariable Long id){
        return ResponseEntity.of(monumentoRepository.findById(id)
                .map(encontrado -> {
                    encontrado.setDescripcion(monumento.getDescripcion());
                    encontrado.setLatitud(monumento.getLatitud());
                    encontrado.setLongitud(monumento.getLongitud());
                    encontrado.setNombre(monumento.getNombre());
                    encontrado.setCodPais(monumento.getCodPais());
                    encontrado.setImgURL(monumento.getImgURL());
                    encontrado.setNombreCiudad(monumento.getNombreCiudad());
                    return monumentoRepository.save(encontrado);
                }));
    }

    @DeleteMapping("/monumento/{id}")
    public ResponseEntity<?> delete(@RequestBody Monumento monumento, @PathVariable Long id){
        if(monumentoRepository.existsById(id))
            monumentoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
