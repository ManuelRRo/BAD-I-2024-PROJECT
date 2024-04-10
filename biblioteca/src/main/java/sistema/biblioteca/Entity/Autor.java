package sistema.biblioteca.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

/**
 * $table.getTableComment()
 */
@Entity
@Table(name = "AUTOR")
public class Autor {

    @Id
    @Column(name = "ID_AUTOR", nullable = false)
    private BigDecimal idAutor;

    @Column(name = "NOMBRE_AUTOR", nullable = false)
    private String nombreAutor;

    public void setIdAutor(BigDecimal idAutor) {
        this.idAutor = idAutor;
    }

    public BigDecimal getIdAutor() {
        return idAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "idAutor=" + idAutor + '\'' +
                "nombreAutor=" + nombreAutor + '\'' +
                '}';
    }
}
