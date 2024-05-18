package sistema.biblioteca.Vistas.CatalogoLibro;

import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import sistema.biblioteca.Entidad.BibliotecaMaterial;
import sistema.biblioteca.Servicio.BiblioMaterialServicio;
import sistema.biblioteca.Servicio.PrestaServicio.PrestaServicio;
import sistema.biblioteca.Vistas.ListPrestamo.ListarPrestamos;
import sistema.biblioteca.Vistas.MainLayout;

import java.util.List;

@Route(value="/",layout = MainLayout.class)
@PageTitle("Catalogo")
@PermitAll
public class Catalogo extends VerticalLayout {

    private TextField filterTituloText = new TextField();
    private TextField filterAutorText = new TextField();
    private Select selectCategoria = new Select();

    private FlexLayout divLayout = new FlexLayout();
    private Scroller scroller = new Scroller();

    private HorizontalLayout filtersBar = new HorizontalLayout();

    @Autowired
    public BiblioMaterialServicio BMservicio;
     public Catalogo(BiblioMaterialServicio BMservicio) {
         this.BMservicio = BMservicio;



         add(
                 new Hr(),
                filtersBar,
                 new Hr(),
                 cargarListaDeLibros(BMservicio)
         );
    }
    public VerticalLayout crearCarta(
            String titulo_carta,
            String idioma_carta,
            String autor_carta,
            String descripcion_carta,
            Long id_material
    ){
        VerticalLayout card = new VerticalLayout();
        card.setHeight("30vh");
        card.setWidth("15vw");
        card.getStyle().set("align-items", "center");
        //h2 titulo
        H4 titulo = new H4 (titulo_carta);
        //img
        Image img_book = new Image("img/red_dragon.jpg","Red Dragon");
        img_book.setWidth("100px");
        img_book.setHeight("150px");
        //Idioma
        H4 idioma = new H4("Idioma: "+idioma_carta);
        //Autor
        H4 autor = new H4("Autor: "+autor_carta);
        //Descripcion
        H4 descripcion = new H4("Descripcion: "+descripcion_carta);

        card.add(
                img_book,
                titulo
               );


        card.addClassName("card-item");
        return  card;
    }
    public Scroller cargarListaDeLibros (BiblioMaterialServicio servicio){

        List<BibliotecaMaterial> listaDeMaterialesBiblioteca= servicio.ListarTodo();

        BibliotecaMaterial bm ;

        int maxItems = 10;

        int count = 0;
        FlexLayout cardLayout = new FlexLayout() ;

        /////////////////////////////////////////
        divLayout.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        divLayout.getStyle().set("gap", "1px");
        divLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        /////////////////////////////////////////
        H1 msg = new H1("No hay libros");

        if (listaDeMaterialesBiblioteca.size() == 0) {
            divLayout.add(msg);
            Scroller scro = new Scroller(divLayout);
            return scro;
        }

        while(count != maxItems && count < listaDeMaterialesBiblioteca.size()){

            bm = new BibliotecaMaterial();

            if(listaDeMaterialesBiblioteca.size() != 0){

                bm=listaDeMaterialesBiblioteca.get(count);

                divLayout.add(crearCarta(bm.getTitulo(), bm.getIdioma().getNombre_idioma(),
                        bm.getAutor().getNombre_autor(), bm.getDescripcion(),bm.getId_material_biblioteca()));

                System.out.println(listaDeMaterialesBiblioteca.size());

                count++;

            }else{
                count = 5;
            }
        }

        //Hacer este scroller global
        scroller.setContent(divLayout);
        scroller.setWidth("100%");
        scroller.setHeight("100vh");
        scroller.setScrollDirection(Scroller.ScrollDirection.VERTICAL);
        scroller.getStyle()
                .set("border-bottom", "1px solid var(--lumo-contrast-20pct)")
                .set("padding", "var(--lumo-space-m)");
        return scroller;

    }

}
