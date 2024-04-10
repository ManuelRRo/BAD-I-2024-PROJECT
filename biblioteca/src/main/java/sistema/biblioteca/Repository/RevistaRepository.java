package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Revista;

public interface RevistaRepository extends JpaRepository<Revista, BigDecimal>, JpaSpecificationExecutor<Revista> {

}