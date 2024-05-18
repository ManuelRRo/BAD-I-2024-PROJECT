package sistema.biblioteca.Repositorio;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sistema.biblioteca.Entidad.Miembro;
@Repository
public interface MiembroRepositorio extends JpaRepository<Miembro,Long> {
    @Query("SELECT m.carnet FROM Miembro m INNER JOIN m.usuario u WHERE u.username = :username")
    String findCarnetByUsername(String username);

}
