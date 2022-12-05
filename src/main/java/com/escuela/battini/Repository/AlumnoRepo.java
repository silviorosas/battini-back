package com.escuela.battini.Repository;

import com.escuela.battini.model.Alumnos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepo extends JpaRepository<Alumnos,Integer> {
    List<Alumnos> findByEspecialidad (String especialidad);
}
