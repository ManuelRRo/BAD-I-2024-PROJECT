package sistema.biblioteca.Vistas.ListPrestamo;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import sistema.biblioteca.Vistas.MainLayout;
import sistema.biblioteca.Entidad.Autor;
import sistema.biblioteca.Entidad.BibliotecaMaterial;
import sistema.biblioteca.Entidad.Idioma;
import sistema.biblioteca.Entidad.Presta;
import sistema.biblioteca.Servicio.BiblioMaterialServicio;

@Route(value="",layout = MainLayout.class)
@PageTitle("Lista Prestamos")
public class ListarPrestamos extends VerticalLayout {

    //grid declaration
    private
    Grid<BibliotecaMaterial> gridBibliotecaMaterial = new Grid<>(BibliotecaMaterial.class);
    //
    @Autowired
    public BiblioMaterialServicio BMservicio;

    public  ListarPrestamos (BiblioMaterialServicio BMservicio){
        
        this.BMservicio = BMservicio;

        configurarGrid();

        HorizontalLayout l2 = new HorizontalLayout(cargarListaDeLibros(BMservicio),gridBibliotecaMaterial);

        //Div content = new Div(gridBibliotecaMaterial);
        add(l2);
        actualizarListaDePrestamos();
    }

    public VerticalLayout crearCarta(
        String titulo_carta,
        String idioma_carta,
        String autor_carta,
        String descripcion_carta
        ){
        VerticalLayout cardLayout = new VerticalLayout();
        //h2 titulo
        H2 titulo = new H2 (titulo_carta);
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

        cardLayout.add(
            titulo,
            img_book,
            idioma,
            autor,
            descripcion);
        
            cardLayout.addClickListener(event -> {
                BMservicio.econtrarPorId(1L);
            });

        return  cardLayout;
    }

    private void configurarGrid(){
        gridBibliotecaMaterial.addClassName("grid-estudiante");
        //gridBibliotecaMaterial.setSizeFull();

        // Remover columna que comparte
        //gridBibliotecaMaterial.removeColumnByKey("grado");
        // poner el nombre igual que en las entidades de clase
        gridBibliotecaMaterial.removeColumnByKey("autor");
        gridBibliotecaMaterial.setColumns("titulo","descripcion","cantidad");

            gridBibliotecaMaterial.addColumn(material -> {
            Autor autor = material.getAutor();
            return autor == null ? "-" : autor.getNombre_autor();
        }).setHeader("Autor");

        gridBibliotecaMaterial.addColumn(material -> {
            Idioma idioma = material.getIdioma();
            return idioma == null ? "-" : idioma.getNombre_idioma();
        }).setHeader("Idioma");

        gridBibliotecaMaterial.addColumn(material -> {
            List<Presta> presta = material.getPresta();
            ///////////////////////////////////////
            String str = "";
            for (Presta valor : presta) {
                System.out.println(valor.getFecha_prestamo());
                str = valor.getFecha_prestamo().toString() + " ,";
                }
            ////////////////////////////////////////
            return presta == null ? "-" : str ;
        }).setHeader("Presta");

        // gridBibliotecaMaterial.addColumn(presta -> {
        //     Presta presta = presta ;
        //     return grado == null ? "-" : grado.getNombre_grado();
        // }).setHeader("Grado");


        // Agregar columna personalizada para mostrar el nombre en lugar del ID
        // gridBibliotecaMaterial.addColumn(estudiante -> {
        //     Grado grado = estudiante.getGrado();
        //     return grado == null ? "-" : grado.getNombre_grado();
        // }).setHeader("Grado");

        gridBibliotecaMaterial.getColumns().forEach(col -> col.setAutoWidth(true));
        gridBibliotecaMaterial.setWidth("700px");

        //gridBibliotecaMaterial.asSingleSelect().addValueChangeListener(event -> editEstudiante(event.getValue()));
    }

    private void actualizarListaDePrestamos() {
        //Aqui iba el filterText get value
        gridBibliotecaMaterial.setItems(BMservicio.econtrarPorId(1L));
        System.out.println("Contenido del grid" + gridBibliotecaMaterial);
    }

    public Scroller cargarListaDeLibros (BiblioMaterialServicio servicio){

        List<BibliotecaMaterial> listaDeMaterialesBiblioteca= servicio.ListarTodo();

        BibliotecaMaterial bm ;

        int maxItems = 7;

        int count = 0;
        FlexLayout cardLayout = new FlexLayout() ;
        /////////////////////////////////////////
        Div divLayout = new Div();
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
                divLayout.add(crearCarta(bm.getTitulo(), bm.getIdioma().getNombre_idioma(), bm.getAutor().getNombre_autor(), bm.getDescripcion()));
                System.out.println(listaDeMaterialesBiblioteca.size());
                count++;
            }else{
                count = 5;
            }
        }
        Scroller scroller = new Scroller(
        divLayout);
        scroller.setWidth("500px");
        scroller.setHeight("300px");
        scroller.setScrollDirection(Scroller.ScrollDirection.VERTICAL);
        scroller.getStyle()
        .set("border-bottom", "1px solid var(--lumo-contrast-20pct)")
        .set("padding", "var(--lumo-space-m)");
        return scroller;      

    }

    // public HorizontalLayout cargarListaDeLibros (BiblioMaterialServicio servicio){

    //     List<BibliotecaMaterial> listaDeMaterialesBiblioteca= servicio.ListarTodo();

    //     BibliotecaMaterial bm ;

    //     int maxItems = 7;

    //     int count = 0;
    //     HorizontalLayout cardLayout = new HorizontalLayout() ;
    //     H1 msg = new H1("No hay libros");

    //     if (listaDeMaterialesBiblioteca.size() == 0) {
    //         cardLayout.add(msg);
    //         return cardLayout;
    //     }

    //     while(count != maxItems && count < listaDeMaterialesBiblioteca.size()){
    //         bm = new BibliotecaMaterial();
    //         if(listaDeMaterialesBiblioteca.size() != 0){
    //             bm=listaDeMaterialesBiblioteca.get(count);
    //             cardLayout.add(crearCarta(bm.getTitulo(), bm.getIdioma().getNombre_idioma(), bm.getAutor().getNombre_autor(), bm.getDescripcion()));
    //             System.out.println(listaDeMaterialesBiblioteca.size());
    //             count++;
    //         }else{
    //             count = 5;
    //         }
    //     }
    //     return cardLayout;      
    // }
}
