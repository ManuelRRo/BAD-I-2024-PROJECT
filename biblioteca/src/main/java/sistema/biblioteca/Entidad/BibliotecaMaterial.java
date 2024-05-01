package sistema.biblioteca.Entidad;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
//No olvidar poner el tipo de fetch para evitar problemas al cargar cosas
@Entity
@Table(name = "BIBLIOTECA_MATERIAL")
public class BibliotecaMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_material_biblioteca;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_idioma",nullable = true)
    private Idioma idioma;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_autor",nullable = true)
    private Autor autor;

//    @ManyToMany
//    @JoinTable(
//            //table name
//            name = "Presta",
//            joinColumns = @JoinColumn(name = "id_material"),
//            inverseJoinColumns = @JoinColumn(name = "id_mora")
//    )
    @OneToMany(mappedBy = "material",fetch = FetchType.EAGER)
    List<Presta> presta;

    @Column(name = "titulo",nullable = true)
    private String titulo;
    @Column(name = "descripcion",nullable = true)
    private String descripcion;
    @Column(name = "cantidad",nullable = true)
    private int cantidad;

    public BibliotecaMaterial(Long id_material_biblioteca, Idioma idioma, Autor autor, List<Presta> presta,
            String titulo, String descripcion, int cantidad) {
        this.id_material_biblioteca = id_material_biblioteca;
        this.idioma = idioma;
        this.autor = autor;
        this.presta = presta;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public BibliotecaMaterial() {
    }

    public BibliotecaMaterial(Idioma idioma, Autor autor, List<Presta> presta, String titulo, String descripcion,
            int cantidad) {
        this.idioma = idioma;
        this.autor = autor;
        this.presta = presta;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public BibliotecaMaterial(Idioma idioma, Autor autor, String titulo, String descripcion, int cantidad) {
        this.idioma = idioma;
        this.autor = autor;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public Long getId_material_biblioteca() {
        return id_material_biblioteca;
    }

    public void setId_material_biblioteca(Long id_material_biblioteca) {
        this.id_material_biblioteca = id_material_biblioteca;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Presta> getPresta() {
        return presta;
    }

    public void setPresta(List<Presta> presta) {
        this.presta = presta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    


}
