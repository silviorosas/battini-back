package com.escuela.battini.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="alumnos")
public class Alumnos {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Integer dni;
    private int edad;
    private String domicilio;
    private String email;
    private Long telefono;
    private String especialidad;

    @Override
    public String toString() {
        return "TE PRE-INSCRIBISTE EXITOSAMENTE: " +'.'+ '\n' +
                "NOMBRE: " + nombre +'.'+ '\n' +
                "DNI: " + dni +'.'+ '\n' +              
                "MAIL: " + email +'.'+ '\n' +              
                "CURSO: " + especialidad +'.'+ '\n' +
                "Ante cualquier consulta puedes escribir a este correo o dirigirte personalmente a nuestra escuela sita en Sarmiento 90 de 14:00 a 23:00 hs."
                ;
    }
}
