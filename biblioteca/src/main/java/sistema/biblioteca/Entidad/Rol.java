package sistema.biblioteca.Entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;

    @Column(name = "nombre_rol",nullable = false)
    private String nombre_rol;

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public Rol(Long id_rol, String nombre_rol) {
        super();
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
    }

    public Rol() {
        super();
    }

    public Rol(String nombre_rol) {
        super();
        this.nombre_rol = nombre_rol;
    }
}
