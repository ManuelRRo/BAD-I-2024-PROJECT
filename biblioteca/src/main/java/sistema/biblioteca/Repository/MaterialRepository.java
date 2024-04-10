package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Material;

public interface MaterialRepository extends JpaRepository<Material, BigDecimal>, JpaSpecificationExecutor<Material> {

}