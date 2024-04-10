package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Formato;

public interface FormatoRepository extends JpaRepository<Formato, BigDecimal>, JpaSpecificationExecutor<Formato> {

}