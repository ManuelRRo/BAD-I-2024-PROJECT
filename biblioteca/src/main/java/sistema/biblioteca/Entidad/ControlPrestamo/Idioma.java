package sistema.biblioteca.Entidad.ControlPrestamo;

import jakarta.persistence.*;

@Entity
public class Idioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_idioma;

    @Column(name = "nombre_idioma",nullable = false)
    private String nombre_idioma;

    public Idioma(long id_idioma, String nombre_idioma) {
        this.id_idioma = id_idioma;
        this.nombre_idioma = nombre_idioma;
    }

    public Idioma() {
    }

    public long getId_idioma() {
        return id_idioma;
    }

    public void setId_idioma(long id_idioma) {
        this.id_idioma = id_idioma;
    }

    public String getNombre_idioma() {
        return nombre_idioma;
    }

    public void setNombre_idioma(String nombre_idioma) {
        this.nombre_idioma = nombre_idioma;
    }
}
