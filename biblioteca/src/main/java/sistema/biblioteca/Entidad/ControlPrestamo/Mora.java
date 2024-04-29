package sistema.biblioteca.Entidad.ControlPrestamo;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Mora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_mora;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_miembro")
    private Miembro miembro;

//    @ManyToMany(mappedBy = "moras")
//    private List<BibliotecaMaterial> biblioteca_material;

    @OneToMany(mappedBy = "mora")
    Set<Presta> presta;

    @Column(name = "mora_prestamo",nullable = false)
    private float mora_prestamo;

    @Column(name = "costo_prestamo",nullable = false)
    private float costo_prestamo;



}
