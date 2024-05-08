package sistema.biblioteca.Vistas.ListPrestamo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
//import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
    private Grid<BibliotecaMaterial> gridBibliotecaMaterial = new Grid<>(BibliotecaMaterial.class);
    private TextField filterText = new TextField();
    private VerticalLayout divLayout = new VerticalLayout();
    private Scroller scroller = new Scroller();
    private List<BibliotecaMaterial> listaMaterialAPrestar = new ArrayList<>();
    private Button btnGuardar = new Button("Guardar");
    private Button btnCancelar = new Button("Cancelar");

    //
    @Autowired
    public BiblioMaterialServicio BMservicio;

    public  ListarPrestamos (BiblioMaterialServicio BMservicio){
        
        this.BMservicio = BMservicio;

        configurarGrid();
        VerticalLayout gestionPrestamosContainer = new VerticalLayout();
        HorizontalLayout botonesPrestamosContainer = new HorizontalLayout();
        botonesPrestamosContainer.add(btnGuardar,btnCancelar);

        gestionPrestamosContainer.add(gridBibliotecaMaterial,botonesPrestamosContainer);
        HorizontalLayout l2 = new HorizontalLayout(cargarListaDeLibros(BMservicio),gestionPrestamosContainer);

        //Div content = new Div(gridBibliotecaMaterial);
        add(BarraDeBusqueda(),l2);
        
    }

    public VerticalLayout crearCarta(
        String titulo_carta,
        String idioma_carta,
        String autor_carta,
        String descripcion_carta,
        Long id_material
        ){
        VerticalLayout card = new VerticalLayout();
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

        card.add(
            titulo,
            img_book,
            idioma,
            autor,
            descripcion);
        
            card.addClickListener(event -> {
                actualizarListaDePrestamos(id_material);
            });

            card.addClassName("card-item");
        return  card;
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
        gridBibliotecaMaterial.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT);

        //gridBibliotecaMaterial.asSingleSelect().addValueChangeListener(event -> editEstudiante(event.getValue()));
    }

    private void actualizarListaDePrestamos(Long id_material) {
        //Aqui iba el filterText get value
        //Agregar Item seleccionado en el listado
        listaMaterialAPrestar.add(BMservicio.econtrarPorId(id_material));
        gridBibliotecaMaterial.setItems(listaMaterialAPrestar);
    }

    public Scroller cargarListaDeLibros (BiblioMaterialServicio servicio){

        List<BibliotecaMaterial> listaDeMaterialesBiblioteca= servicio.ListarTodo();

        BibliotecaMaterial bm ;

        int maxItems = 7;

        int count = 0;
        FlexLayout cardLayout = new FlexLayout() ;

        /////////////////////////////////////////
        
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
        scroller.setWidth("500px");
        scroller.setHeight("300px");
        scroller.setScrollDirection(Scroller.ScrollDirection.VERTICAL);
        scroller.getStyle()
        .set("border-bottom", "1px solid var(--lumo-contrast-20pct)")
        .set("padding", "var(--lumo-space-m)");
        return scroller;      

    }

    public HorizontalLayout BarraDeBusqueda(){
        H3 lblBuscar = new H3("Buscar");
        filterText.setPlaceholder("Filtrar por nombre...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);

        // invocar el updateList(); cada vez que l caja de texto cambie de estado
        filterText.addValueChangeListener(
            //e -> actualizarListaDePrestamos()
            e-> actualizarListadoLibros(0,5,filterText.getValue())
            );

        // Button addContactButton = new Button("Add contact");
        // addContactButton.addClickListener(click -> addEstudiante());

        //HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);
        
        HorizontalLayout barraDeBusqueda = new HorizontalLayout(
            lblBuscar,filterText
        );
        return barraDeBusqueda;
    }
    
    private void actualizarListadoLibros(int count,int maxItems,String filterValue){
        List<BibliotecaMaterial> listaDeMaterialesBiblioteca = BMservicio.ListarTodo(filterValue);
        BibliotecaMaterial bm;
        //Eliminar los que se ven
        List<Component> componentList = divLayout.getChildren().collect(Collectors.toList());
                String nombreClase = "card-item";
                
                for (Component component : componentList) {
                    
                    if (component.getClassName().equals(nombreClase)) {
                        // Eliminar el componente del Div
                        divLayout.remove(component);
                    }
                }
        while(count != maxItems && count < listaDeMaterialesBiblioteca.size()){

            bm = new BibliotecaMaterial();

            if(listaDeMaterialesBiblioteca.size() != 0){

                bm=listaDeMaterialesBiblioteca.get(count);

                divLayout.add(crearCarta(bm.getTitulo(), bm.getIdioma().getNombre_idioma(), bm.getAutor().getNombre_autor(), bm.getDescripcion(),bm.getId_material_biblioteca()));

                System.out.println(listaDeMaterialesBiblioteca.size());

                count++;

            }else{
                count = 5;
            }
        }
        //Crear nuevo con la nueva query
    }

    //TODO
    //1.Crear una nueva funcion actualizarListadoLibros
    //2.pegar el codigo para borrar las cartas
    //3.hacer una nueva funcion que genere el layout con todas las cartas recibiendo una lista
    //como parametro
    //4.voy a agregar el elemento al scroller
    // //Logica para borrar cartas
    // List<Component> componentList = divLayout.getChildren().collect(Collectors.toList());
    // String nombreClase = "card-item";
    
    // for (Component component : componentList) {
        
    //     if (component.getClassName().equals(nombreClase)) {
    //         // Eliminar el componente del Div
    //         divLayout.remove(component);
    //     }
    // }
}
