package com.escuela.battini.controller;

import com.escuela.battini.Repository.AlumnoRepo;
import com.escuela.battini.model.Alumnos;
import com.escuela.battini.service.AlumnoService;
import com.escuela.battini.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/")
@CrossOrigin(origins = "https://escuela-battini.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class AlumnoController {

    private final AlumnoService repo;

    public AlumnoController(AlumnoService repo, MailService mailService, AlumnoRepo repoParaMail) {
        this.repo = repo;
        this.repoParaMail = repoParaMail;
    }

    @Autowired
    private  MailService mailService;
    private final AlumnoRepo repoParaMail;


    @GetMapping
    public List<Alumnos> getAll(){
        return repo.getAll();
    }

    @PostMapping
    public Alumnos save (@RequestBody Alumnos alumnos ){

        Alumnos newAlumno = repoParaMail.save(alumnos);
        if(newAlumno != null){
            mailService.sendMail(newAlumno.getEmail(),"Pre-Inscripto en CCT Concejal Battini",newAlumno.toString());
        }
        return newAlumno;
    }
   /* @PostMapping
    public ResponseEntity<Alumnos> save (@RequestBody Alumnos alumnos ){
        return repo.save(alumnos);
    }*/
    @PutMapping
    public ResponseEntity<Alumnos> update (@RequestBody Alumnos alumnos ){
        return repo.update(alumnos);
    }

    @DeleteMapping(value= "/delete/{id}")
    public ResponseEntity<Alumnos> delete (@PathVariable Integer id){
        return repo.delete(id);
    }


    @GetMapping("/especialidad")
    public List<Alumnos> getFilterEspecialidad(@RequestParam(name = "especialidad", required = false) String especialidad){
        return repo.findByEspecialidad(especialidad);
    }

    @GetMapping("/nombre")
    public List<Alumnos> getFilterNombre(@RequestParam(name = "nombre", required = false) String nombre){
        return repo.findByNombre(nombre);
    }

    @GetMapping("/dni")
    public List<Alumnos> getFilterDni(@RequestParam(name = "dni", required = false) Integer dni){
        return repo.findByDni(dni);
    }
}
