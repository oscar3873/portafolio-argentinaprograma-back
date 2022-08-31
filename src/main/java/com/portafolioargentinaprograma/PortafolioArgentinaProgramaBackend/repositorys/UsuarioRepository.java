
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.repositorys;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
