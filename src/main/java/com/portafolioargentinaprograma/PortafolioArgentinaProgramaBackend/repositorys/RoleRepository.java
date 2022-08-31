
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.repositorys;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Role;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.RoleName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(RoleName roleName);
}
