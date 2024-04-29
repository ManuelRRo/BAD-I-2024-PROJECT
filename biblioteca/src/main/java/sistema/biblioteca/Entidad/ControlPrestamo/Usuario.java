package sistema.biblioteca.Entidad.ControlPrestamo;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;
    @Column(name = "nombre_usuario",nullable = false)
    private String nombre_usuario;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "correo",nullable = false)
    private String correo;

    @Column(name = "password",nullable = false)
    private String password;

}
