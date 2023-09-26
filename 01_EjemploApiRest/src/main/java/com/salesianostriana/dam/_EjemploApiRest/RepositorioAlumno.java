package com.salesianostriana.dam._EjemploApiRest;

import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioAlumno {
    private List<Alumno> alumnos;

    public RepositorioAlumno(){

    }

    public List<Alumno> findAll(){
        return Collections.unmodifiableList(alumnos);
    }
    public Optional<Alumno> findById(int id){
        return alumnos.stream()
                .filter(a -> a.getId()==id)
                .findFirst();
    }
    public int indexOf(int id){
        int pos=-1;
        for (int i = 0; i < alumnos.size() && pos != -1; i++) {
            if(alumnos.get(i).getId()==id){
                pos=1;
            }
        }
        return pos;
    }
    public Alumno save(Alumno a){
        alumnos.add(a);
        return a;
    }
    public void delete(Alumno a){
        int pos;
        if((pos = indexOf(a.getId()))==-1) {
            alumnos.remove(a);
        }
    }
    public Alumno edit(Alumno a){
        int pos;
        if((pos = indexOf(a.getId()))==-1){
            return save(a);
        }else{
            return alumnos.set(pos,a);
        }
    }
}
