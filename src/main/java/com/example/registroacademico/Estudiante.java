package com.example.registroacademico;

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")
})
@Entity
public class Estudiante implements Serializable {
    private  static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idestudiante;
    private String carnet;

    public int getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(int id) {
        this.idestudiante = id;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombres) {
        this.nombre = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellidos) {
        this.apellido = apellidos;
    }

    private String nombre;
    private String apellido;
}
