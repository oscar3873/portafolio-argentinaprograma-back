
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String ftoPerfil;
    private String titulo;
    private String infoPersona;
    private String ftoPortada;
    
    public Persona(){}

    public Persona(Long id, String nombre, String ftoPerfil, String titulo, String infoPersona, String ftoPortada) {
        this.id = id;
        this.nombre = nombre;
        this.ftoPerfil = ftoPerfil;
        this.titulo = titulo;
        this.infoPersona = infoPersona;
        this.ftoPortada = ftoPortada;
    }
    
    
}
