package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Cd;

public interface CdRepository extends JpaRepository<Cd, BigDecimal>, JpaSpecificationExecutor<Cd> {

}