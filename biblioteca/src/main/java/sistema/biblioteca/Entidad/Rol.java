package sistema.biblioteca.Entidad;

import jakarta.persistence.*;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;

    @Column(name = "nombre_rol")
    private String nombre_rol;

    public Rol() {
    }

    public Rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }
}
