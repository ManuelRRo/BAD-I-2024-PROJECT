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
@Table(name = "IDIOMA")
public class Idioma {

    @Id
    @Column(name = "ID_IDIOMA", nullable = false)
    private BigDecimal idIdioma;

    @Column(name = "NOMBRE_IDIOMA")
    private String nombreIdioma;

    public void setIdIdioma(BigDecimal idIdioma) {
        this.idIdioma = idIdioma;
    }

    public BigDecimal getIdIdioma() {
        return idIdioma;
    }

    public void setNombreIdioma(String nombreIdioma) {
        this.nombreIdioma = nombreIdioma;
    }

    public String getNombreIdioma() {
        return nombreIdioma;
    }

    @Override
    public String toString() {
        return "Idioma{" +
                "idIdioma=" + idIdioma + '\'' +
                "nombreIdioma=" + nombreIdioma + '\'' +
                '}';
    }
}
