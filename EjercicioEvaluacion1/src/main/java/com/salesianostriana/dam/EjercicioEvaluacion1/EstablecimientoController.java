package com.salesianostriana.dam.EjercicioEvaluacion1;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class EstablecimientoController {

    private final EstablecimientoRespository establecimientoRespository;

    @GetMapping("/place/")
    public ResponseEntity<List<Establecimiento>> getAll(){
        List<Establecimiento> lista = establecimientoRespository.findAll();

        if(lista.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/place/{id}")
    public ResponseEntity<Establecimiento> findById(@PathVariable Long id){
        return ResponseEntity.of(establecimientoRespository.findById(id));
    }

    @PostMapping("/place/")
    public ResponseEntity<Establecimiento> create(@RequestBody Establecimiento establecimiento){
        Establecimiento nuevo = establecimientoRespository.save(establecimiento);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/place/{id}")
    public ResponseEntity<Establecimiento> edit(@PathVariable Long id, @RequestBody Establecimiento establecimiento){
        return ResponseEntity.of(establecimientoRespository.findById(id)
                .map(antiguo -> {
                    antiguo.setDescripcion(establecimiento.getDescripcion());
                    antiguo.setCiudad(establecimiento.getCiudad());
                    antiguo.setCalle(establecimiento.getCalle());
                    antiguo.setLatitud(establecimiento.getLatitud());
                    antiguo.setLongitud(establecimiento.getLongitud());
                    antiguo.setUrlImg(establecimiento.getUrlImg());
                    antiguo.setNombre(establecimiento.getNombre());
                    return establecimientoRespository.save(antiguo);
                }));
    }

    @PutMapping("/place/{id}/tag/add/{nuevo_tag}")
    public ResponseEntity<Establecimiento> addTag(@PathVariable Long id, @PathVariable String nuevo_tag){

        return ResponseEntity.of(establecimientoRespository.findById(id)
                .map(antiguo -> {
                    antiguo.getTag().add(nuevo_tag);
                    return establecimientoRespository.save(antiguo);
        }));

    }

    @PutMapping("/place/{id}/tag/del/{tag}")
    public ResponseEntity<Establecimiento> deleteTag(@PathVariable Long id, @PathVariable String tag){

        return ResponseEntity.of(establecimientoRespository.findById(id)
                .map(antiguo -> {
                    antiguo.getTag().remove(tag);
                     return establecimientoRespository.save(antiguo);
        }));
    }

    @DeleteMapping("/place/{id}")
    public ResponseEntity<Establecimiento> delete(@PathVariable Long id){
        if(establecimientoRespository.existsById(id))
            establecimientoRespository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}
