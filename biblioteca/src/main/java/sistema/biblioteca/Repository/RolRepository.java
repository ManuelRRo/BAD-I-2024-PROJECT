package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Rol;

public interface RolRepository extends JpaRepository<Rol, BigDecimal>, JpaSpecificationExecutor<Rol> {

}