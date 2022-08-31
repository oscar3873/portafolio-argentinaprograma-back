
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String puesto;
    private String detalle;
    private String logo;

    public Experiencia() {
    }

    public Experiencia(String nombre, String puesto, String detalle, String logo) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.detalle = detalle;
        this.logo = logo;
    }

}
