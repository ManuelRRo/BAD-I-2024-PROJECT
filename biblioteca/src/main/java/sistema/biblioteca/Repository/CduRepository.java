package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Cdu;

public interface CduRepository extends JpaRepository<Cdu, BigDecimal>, JpaSpecificationExecutor<Cdu> {

}