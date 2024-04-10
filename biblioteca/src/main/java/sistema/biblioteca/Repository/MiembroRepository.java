package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Miembro;

public interface MiembroRepository extends JpaRepository<Miembro, BigDecimal>, JpaSpecificationExecutor<Miembro> {

}