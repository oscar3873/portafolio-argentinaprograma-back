
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.services;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Persona;
import java.util.List;

public interface IPersonaService {
        public List<Persona> verPersona();
    public void crearPersona(Persona p);
    public void borrarPersona(Long id);
    public Persona buscarPersona(Long id);
}
