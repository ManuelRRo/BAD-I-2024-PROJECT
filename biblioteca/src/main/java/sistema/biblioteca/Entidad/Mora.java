package sistema.biblioteca.Entidad;

import jakarta.persistence.*;

@Entity
public class Mora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_mora;

    @Column(name = "mora_prestamo",nullable = false)
    private float mora_prestamo;

    @Column(name = "costo_prestamo",nullable = false)
    private float costo_prestamo;

}
