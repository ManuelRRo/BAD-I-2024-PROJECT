package sistema.biblioteca.Repositorio;
import org.hibernate.dialect.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import sistema.biblioteca.Entidad.BibliotecaMaterial;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;
import java.util.Objects;

@Repository
public interface BibliotecaMaterialRepositorio extends JpaRepository<BibliotecaMaterial,Long> {
    @Query("select e from BibliotecaMaterial e " +
    "where lower(e.titulo) like lower(concat('%',:searchTerm,'%'))")// +
    //"or lower(e.apellido) like lower(concat('%',:searchTerm,'%'))")
    List<BibliotecaMaterial> BuscarMaterial(@Param("searchTerm") String searchTerm);

    @Query(value = "{call listaDeLibrosPorAutor(:nombreAutor,:CURSOR_)}",nativeQuery = true)
    List<BibliotecaMaterial> listaDeLibrosPorAutor(@Param("nombreAutor") String nombre,@Param("CURSOR_") List<Object> l);


}
