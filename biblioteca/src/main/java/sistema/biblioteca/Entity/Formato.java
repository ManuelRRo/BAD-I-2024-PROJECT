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
@Table(name = "FORMATO")
public class Formato {

    @Id
    @Column(name = "ID_FORMATO", nullable = false)
    private BigDecimal idFormato;

    @Column(name = "NOMBRE_FORMATO", nullable = false)
    private String nombreFormato;

    public void setIdFormato(BigDecimal idFormato) {
        this.idFormato = idFormato;
    }

    public BigDecimal getIdFormato() {
        return idFormato;
    }

    public void setNombreFormato(String nombreFormato) {
        this.nombreFormato = nombreFormato;
    }

    public String getNombreFormato() {
        return nombreFormato;
    }

    @Override
    public String toString() {
        return "Formato{" +
                "idFormato=" + idFormato + '\'' +
                "nombreFormato=" + nombreFormato + '\'' +
                '}';
    }
}
