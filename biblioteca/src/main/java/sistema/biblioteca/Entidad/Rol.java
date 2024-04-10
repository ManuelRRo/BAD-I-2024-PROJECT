package sistema.biblioteca.Entidad;

import jakarta.persistence.*;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_rol;

    @Column(name = "nombre_rol",nullable = false)
    private String nombre_rol;

}
