package sistema.biblioteca.Repositorio;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcCallOperations;
import org.springframework.stereotype.Repository;
import sistema.biblioteca.Entidad.BibliotecaMaterial;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BibliotecaMaterialRepository {

    private final SimpleJdbcCallOperations simpleJdbcCall;

    public BibliotecaMaterialRepository(DataSource dataSource) {
        this.simpleJdbcCall = new SimpleJdbcCall(dataSource)
                .withProcedureName("listaDeLibrosPorAutor")
                .returningResultSet("CURSOR_", 
                    BeanPropertyRowMapper.newInstance(BibliotecaMaterial.class))
                .declareParameters(
                        new SqlParameter("nombreAutor", Types.VARCHAR),
                        new SqlOutParameter("CURSOR_", Types.REF_CURSOR)
                );
    }

    public List<BibliotecaMaterial> listaDeLibrosPorAutor(String nombreAutor) {
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("nombreAutor", nombreAutor);

        Map<String, Object> outParams = simpleJdbcCall.execute(inParams);
        return (List<BibliotecaMaterial>) outParams.get("CURSOR_");
    }
}