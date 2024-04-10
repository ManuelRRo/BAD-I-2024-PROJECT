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
@Table(name = "POSEE")
public class Posee {

    @Id
    @Column(name = "ID_ROL", nullable = false)
    private BigDecimal idRol;

    @Id
    @Column(name = "ID_PERMISO", nullable = false)
    private BigDecimal idPermiso;

    public void setIdRol(BigDecimal idRol) {
        this.idRol = idRol;
    }

    public BigDecimal getIdRol() {
        return idRol;
    }

    public void setIdPermiso(BigDecimal idPermiso) {
        this.idPermiso = idPermiso;
    }

    public BigDecimal getIdPermiso() {
        return idPermiso;
    }

    @Override
    public String toString() {
        return "Posee{" +
                "idRol=" + idRol + '\'' +
                "idPermiso=" + idPermiso + '\'' +
                '}';
    }
}
