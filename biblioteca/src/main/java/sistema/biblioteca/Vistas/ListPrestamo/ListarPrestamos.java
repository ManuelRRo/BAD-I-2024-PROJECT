package sistema.biblioteca.Vistas.ListPrestamo;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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
        HorizontalLayout cardLayout = new HorizontalLayout(
        crearCarta("Red Dragon","Inglés","Thomas Harris","Amazing Thriller"),
        crearCarta("Blue Dragon","Inglés","Thomas Harris","Amazing Thriller")
        );
        configurarGrid();

        //Div content = new Div(gridBibliotecaMaterial);
        add(gridBibliotecaMaterial,cardLayout);
        updateList();
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
        img_book.setWidth("200px");
        img_book.setHeight("300px");
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
                // //Podemos usar como notificacion despues de guardar algo
                // Notification notification = Notification
                // .show(titulo_carta);

                //NOTA agregar aqui pasar todos los datos de la carta
                //a otra clase para que los agregue a la otra tabla
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

        //gridBibliotecaMaterial.asSingleSelect().addValueChangeListener(event -> editEstudiante(event.getValue()));
    }

    private void updateList() {
        //Aqui iba el filterText get value
        gridBibliotecaMaterial.setItems(BMservicio.ListarTodo());
    }
}
