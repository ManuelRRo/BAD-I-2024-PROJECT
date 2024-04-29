package sistema.biblioteca.Entidad.ControlPrestamo;

import jakarta.persistence.*;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_autor;

    @Column(name = "nombre_autor",nullable = false)
    private String nombre_autor;

    public Autor(long id_autor, String nombre_autor) {
        this.id_autor = id_autor;
        this.nombre_autor = nombre_autor;
    }

    public Autor() {
    }

    public long getId_autor() {
        return id_autor;
    }

    public void setId_autor(long id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }
}
