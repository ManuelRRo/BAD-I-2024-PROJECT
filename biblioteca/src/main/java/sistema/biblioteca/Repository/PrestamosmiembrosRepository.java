package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Prestamosmiembros;

public interface PrestamosmiembrosRepository extends JpaRepository<Prestamosmiembros, BigDecimal>, JpaSpecificationExecutor<Prestamosmiembros> {

}