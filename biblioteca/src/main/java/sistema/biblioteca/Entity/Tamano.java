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
@Table(name = "TAMANO")
public class Tamano {

    @Id
    @Column(name = "ID_TAMANO", nullable = false)
    private BigDecimal idTamano;

    @Column(name = "ANCHO")
    private BigDecimal ancho;

    @Column(name = "ALTO")
    private String alto;

    public void setIdTamano(BigDecimal idTamano) {
        this.idTamano = idTamano;
    }

    public BigDecimal getIdTamano() {
        return idTamano;
    }

    public void setAncho(BigDecimal ancho) {
        this.ancho = ancho;
    }

    public BigDecimal getAncho() {
        return ancho;
    }

    public void setAlto(String alto) {
        this.alto = alto;
    }

    public String getAlto() {
        return alto;
    }

    @Override
    public String toString() {
        return "Tamano{" +
                "idTamano=" + idTamano + '\'' +
                "ancho=" + ancho + '\'' +
                "alto=" + alto + '\'' +
                '}';
    }
}
