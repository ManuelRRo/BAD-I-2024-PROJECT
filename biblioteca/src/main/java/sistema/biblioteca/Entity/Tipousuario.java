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
@Table(name = "TIPOUSUARIO")
public class Tipousuario {

    @Id
    @Column(name = "ID_TIPO_USUARIO", nullable = false)
    private BigDecimal idTipoUsuario;

    @Column(name = "NOMBRE_TIPO_USUARIO", nullable = false)
    private String nombreTipoUsuario;

    public void setIdTipoUsuario(BigDecimal idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public BigDecimal getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setNombreTipoUsuario(String nombreTipoUsuario) {
        this.nombreTipoUsuario = nombreTipoUsuario;
    }

    public String getNombreTipoUsuario() {
        return nombreTipoUsuario;
    }

    @Override
    public String toString() {
        return "Tipousuario{" +
                "idTipoUsuario=" + idTipoUsuario + '\'' +
                "nombreTipoUsuario=" + nombreTipoUsuario + '\'' +
                '}';
    }
}
