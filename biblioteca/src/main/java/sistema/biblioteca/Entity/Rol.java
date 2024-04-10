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
@Table(name = "ROL")
public class Rol {

    @Id
    @Column(name = "ID_ROL", nullable = false)
    private BigDecimal idRol;

    @Column(name = "NOMBRE_ROL", nullable = false)
    private String nombreRol;

    public void setIdRol(BigDecimal idRol) {
        this.idRol = idRol;
    }

    public BigDecimal getIdRol() {
        return idRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "idRol=" + idRol + '\'' +
                "nombreRol=" + nombreRol + '\'' +
                '}';
    }
}
