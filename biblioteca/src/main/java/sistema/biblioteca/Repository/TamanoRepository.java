package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Tamano;

public interface TamanoRepository extends JpaRepository<Tamano, BigDecimal>, JpaSpecificationExecutor<Tamano> {

}