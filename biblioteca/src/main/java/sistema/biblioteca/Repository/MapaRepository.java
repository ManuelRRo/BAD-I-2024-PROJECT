package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Mapa;

public interface MapaRepository extends JpaRepository<Mapa, BigDecimal>, JpaSpecificationExecutor<Mapa> {

}