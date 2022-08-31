
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
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private boolean completo;
    private String titulo;
    private String logo;
    private Date anioIngreso;
    private Date anioEgreso;
    
    public Educacion(){
        
    }
    
    public Educacion(String nombre, boolean completo, String titulo, String logo, Date anioIngreso, Date anioEgreso) {
        this.nombre = nombre;
        this.completo = completo;
        this.titulo = titulo;
        this.logo = logo;
        this.anioIngreso = anioIngreso;
        this.anioEgreso = anioEgreso;
    }
    
}
