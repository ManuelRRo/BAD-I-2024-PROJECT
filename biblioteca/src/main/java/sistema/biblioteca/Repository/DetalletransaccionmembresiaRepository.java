package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Detalletransaccionmembresia;

public interface DetalletransaccionmembresiaRepository extends JpaRepository<Detalletransaccionmembresia, BigDecimal>, JpaSpecificationExecutor<Detalletransaccionmembresia> {

}