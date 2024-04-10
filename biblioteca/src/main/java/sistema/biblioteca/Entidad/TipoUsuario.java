package sistema.biblioteca.Entidad;

import jakarta.persistence.*;

@Entity
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_tipo_usuario;
    @Column(name = "nombre_tipo_usuario",nullable = false)
    private String nombre_tipo_usuario;
}
