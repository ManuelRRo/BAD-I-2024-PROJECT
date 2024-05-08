package sistema.biblioteca.Entidad;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Mora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mora;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="carnet_miembro")
    private Miembro miembro;

//    @ManyToMany(mappedBy = "moras")
//    private List<BibliotecaMaterial> biblioteca_material;

    @OneToMany(mappedBy = "mora",fetch = FetchType.EAGER )
    Set<Presta> presta;

    @Column(name = "mora_prestamo",nullable = false)
    private float mora_prestamo;

    @Column(name = "costo_prestamo",nullable = false)
    private float costo_prestamo;





}
