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
        if(lista.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/monumento/{id}")
    public ResponseEntity<Monumento> findById(@PathVariable Long id){
        return ResponseEntity.of(monumentoRepository.findById(id));
    }

    @PostMapping("/monumento/")
    public ResponseEntity<Monumento> create(@RequestBody Monumento monumento){
        Monumento nuevo = monumentoRepository.save(monumento);
        return  ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/monumento/{id}")
    public ResponseEntity<Monumento> edit(@RequestBody Monumento monumento, @PathVariable Long id){
        return ResponseEntity.of(monumentoRepository.findById(id)
                .map(antiguo -> {
                    antiguo.setLatitud(monumento.getLatitud());
                    antiguo.setDescripcion(monumento.getDescripcion());
                    antiguo.setImgURL(monumento.getImgURL());
                    antiguo.setCodPais(monumento.getCodPais());
                    antiguo.setNombreCiudad(monumento.getNombreCiudad());
                    antiguo.setLongitud(monumento.getLongitud());
                    antiguo.setNombrePais(monumento.getNombrePais());
                    antiguo.setNombre(monumento.getNombre());
                    return monumentoRepository.save(antiguo);
                }));
    }

    @DeleteMapping("/monumento/{id}")
    public ResponseEntity<Monumento> delete(@PathVariable Long id){
        if(monumentoRepository.existsById(id))
            monumentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
