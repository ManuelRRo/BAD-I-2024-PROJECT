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
@Table(name = "USA")
public class Usa {

    @Id
    @Column(name = "ID_USUARIO", nullable = false)
    private BigDecimal idUsuario;

    @Id
    @Column(name = "ID_ROL", nullable = false)
    private BigDecimal idRol;

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdRol(BigDecimal idRol) {
        this.idRol = idRol;
    }

    public BigDecimal getIdRol() {
        return idRol;
    }

    @Override
    public String toString() {
        return "Usa{" +
                "idUsuario=" + idUsuario + '\'' +
                "idRol=" + idRol + '\'' +
                '}';
    }
}
