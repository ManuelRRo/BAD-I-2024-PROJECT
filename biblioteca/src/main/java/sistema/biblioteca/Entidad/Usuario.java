package sistema.biblioteca.Entidad;

import jakarta.persistence.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    @Column(name = "nombre_usuario",nullable = false)
    private String nombre_usuario;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "correo",nullable = false)
    private String correo;

    @Column(name = "password",nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol",nullable = true)
    private Rol rol;

    public Usuario() {
    }

    public Usuario(Long id_usuario, String nombre_usuario, String username, String correo, String password) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.username = username;
        this.correo = correo;
        this.password = password;
    }

    public Usuario(String nombre_usuario, String username, String correo, String password) {
        this.nombre_usuario = nombre_usuario;
        this.username = username;
        this.correo = correo;
        this.password = password;
    }

//    public Long getId_usuario() {
//        return id_usuario;
//    }

//    public void setId_usuario(Long id_usuario) {
//        this.id_usuario = id_usuario;
//    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
