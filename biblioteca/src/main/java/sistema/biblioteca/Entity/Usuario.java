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
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @Column(name = "ID_USUARIO", nullable = false)
    private BigDecimal idUsuario;

    @Column(name = "ID_TIPO_USUARIO")
    private BigDecimal idTipoUsuario;

    @Column(name = "CARNET")
    private BigDecimal carnet;

    @Column(name = "NOMBRE_USUARIO", nullable = false)
    private String nombreUsuario;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "CORREO", nullable = false)
    private String correo;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdTipoUsuario(BigDecimal idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public BigDecimal getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setCarnet(BigDecimal carnet) {
        this.carnet = carnet;
    }

    public BigDecimal getCarnet() {
        return carnet;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario + '\'' +
                "idTipoUsuario=" + idTipoUsuario + '\'' +
                "carnet=" + carnet + '\'' +
                "nombreUsuario=" + nombreUsuario + '\'' +
                "username=" + username + '\'' +
                "correo=" + correo + '\'' +
                "password=" + password + '\'' +
                '}';
    }
}
