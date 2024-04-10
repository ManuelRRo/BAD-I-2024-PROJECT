package sistema.biblioteca.Entidad;

import jakarta.persistence.*;

@Entity
public class Miembro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carnet;

    @Column(name = "nombre_idioma",nullable = false)
    private boolean penalizado;
}
