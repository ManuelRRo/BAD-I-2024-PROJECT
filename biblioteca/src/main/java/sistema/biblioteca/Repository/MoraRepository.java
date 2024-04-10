package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Mora;

public interface MoraRepository extends JpaRepository<Mora, BigDecimal>, JpaSpecificationExecutor<Mora> {

}