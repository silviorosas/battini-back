package com.escuela.battini.controller;

import com.escuela.battini.Repository.AlumnoRepo;
import com.escuela.battini.model.Alumnos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/")
@CrossOrigin(origins = "https://escuela-battini.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class AlumnoController {

    private final AlumnoRepo repo;

    public AlumnoController(AlumnoRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Alumnos> getAll(){
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<Alumnos> save (@RequestBody Alumnos alumnos ){
        Alumnos obj =repo.save(alumnos);
        return new ResponseEntity<Alumnos>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<Alumnos> delete (@PathVariable Integer id){
        Alumnos alumnos = repo.findById(id).get();
        if(alumnos != null){
            repo.deleteById(id);
        }else{
            return new ResponseEntity<Alumnos> (alumnos, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Alumnos>(alumnos,HttpStatus.OK);
    }


    @GetMapping("/esp")
    public List<Alumnos> getFilterEspecialidad(@RequestParam(name = "especialidad", required = false) String especialidad){
        return repo.findByEspecialidad(especialidad);
    }
}
