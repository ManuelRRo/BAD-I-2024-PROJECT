package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Posee;

public interface PoseeRepository extends JpaRepository<Posee, BigDecimal>, JpaSpecificationExecutor<Posee> {

}