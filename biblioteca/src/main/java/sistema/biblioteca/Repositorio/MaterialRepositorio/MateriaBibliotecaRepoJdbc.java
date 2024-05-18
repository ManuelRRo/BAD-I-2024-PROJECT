package sistema.biblioteca.Repositorio.MaterialRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import sistema.biblioteca.Entidad.Autor;
import sistema.biblioteca.Entidad.BibliotecaMaterial;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class MateriaBibliotecaRepoJdbc {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<BibliotecaMaterial> getLibrosPorAutor(String autorNombre){
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
            .withSchemaName("BIBLIOTECARIO")
            .withProcedureName("LISTADELIBROSPORAUTOR")
            .declareParameters(new SqlParameter[]{
                    new SqlParameter("nombreAutor", Types.VARCHAR),
                    new SqlOutParameter("CURSOR_",Types.REF_CURSOR),
                    new SqlOutParameter("o_sqlcode", Types.INTEGER),
                    new SqlOutParameter("o_sqlmsg",Types.VARCHAR)
            })
            .returningResultSet("CURSOR_", new RowMapper<BibliotecaMaterial>() {
                @Override
                public BibliotecaMaterial mapRow(ResultSet rs,int rowNum) throws SQLException{
                    BibliotecaMaterial material = new BibliotecaMaterial();
                    Autor autor = new Autor();
                    material.setTitulo(rs.getString(1));
                    material.setDescripcion(rs.getString(2));
                    autor.setNombre_autor(rs.getString(3));
                    material.setAutor(autor);

                    return material;
                }
            });
//            .returningResultSet("o_sqlmsg", new RowMapper<String>() {
//                @Override
//                public String mapRow(ResultSet rs2,int rowNum) throws SQLException{
//                    String str = rs2.getString(1);
//                    return  str;
//                }
//            });

            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue("nombreAutor",autorNombre);
            Map<String,Object> results = simpleJdbcCall.execute(mapSqlParameterSource);

            List<BibliotecaMaterial> librosPorAutor = (List<BibliotecaMaterial>) results.get("CURSOR_");
            System.out.println("Mensaje: "+results.get("o_sqlmsg"));

            return librosPorAutor;
    }
}
