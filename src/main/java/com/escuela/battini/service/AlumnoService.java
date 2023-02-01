package com.escuela.battini.service;

import com.escuela.battini.Repository.AlumnoRepo;
import com.escuela.battini.model.Alumnos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class AlumnoService {
    private final AlumnoRepo repo;

    public AlumnoService(AlumnoRepo repo) {
        this.repo = repo;
    }


    public List<Alumnos> getAll(){
        return repo.findAll();
    }


    public ResponseEntity<Alumnos> save (@RequestBody Alumnos alumnos ){
        Alumnos obj =repo.save(alumnos);
        return new ResponseEntity<Alumnos>(obj, HttpStatus.OK);
    }

    public ResponseEntity<Alumnos> update (@RequestBody Alumnos alumnos ){
        Alumnos obj =repo.save(alumnos);
        return new ResponseEntity<Alumnos>(obj, HttpStatus.OK);
    }


    public ResponseEntity<Alumnos> delete (@PathVariable Integer id){
        Alumnos alumnos = repo.findById(id).get();
        if(alumnos != null){
            repo.deleteById(id);
        }else{
            return new ResponseEntity<Alumnos> (alumnos, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Alumnos>(alumnos,HttpStatus.OK);
    }

    public List<Alumnos> findByEspecialidad(String especialidad) {

        return repo.findByEspecialidad(especialidad);
    }

    public List<Alumnos> findByNombre(String nombre) {

        return  repo.findByNombre(nombre);
    }

    public List<Alumnos> findByDni(Integer dni) {

        return repo.findByDni(dni);
    }
}
