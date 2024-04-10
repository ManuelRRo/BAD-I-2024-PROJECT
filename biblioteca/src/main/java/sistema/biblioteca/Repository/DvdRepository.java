package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Dvd;

public interface DvdRepository extends JpaRepository<Dvd, BigDecimal>, JpaSpecificationExecutor<Dvd> {

}