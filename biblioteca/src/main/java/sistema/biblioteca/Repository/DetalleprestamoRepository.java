package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Detalleprestamo;

public interface DetalleprestamoRepository extends JpaRepository<Detalleprestamo, BigDecimal>, JpaSpecificationExecutor<Detalleprestamo> {

}