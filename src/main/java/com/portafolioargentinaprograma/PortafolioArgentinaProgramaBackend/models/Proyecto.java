
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity

public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String url;
    private String detalle;
    private String logo;
    private Date fchaRealizacion;

    public Proyecto(){
        
    }
    
    public Proyecto(String nombre, String url, String detalle, String logo, Date fchaRealizacion) {
        this.nombre = nombre;
        this.url = url;
        this.detalle = detalle;
        this.logo = logo;
        this.fchaRealizacion = fchaRealizacion;
    }
    
    
}

