package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Usa;

public interface UsaRepository extends JpaRepository<Usa, BigDecimal>, JpaSpecificationExecutor<Usa> {

}