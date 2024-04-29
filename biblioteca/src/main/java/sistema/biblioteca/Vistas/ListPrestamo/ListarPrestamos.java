package sistema.biblioteca.Vistas.ListPrestamo;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import sistema.biblioteca.Vistas.MainLayout;

@Route(value="",layout = MainLayout.class)
@PageTitle("Lista Prestamos")
public class ListarPrestamos extends VerticalLayout {
    public  ListarPrestamos (){
        HorizontalLayout cardLayout = new HorizontalLayout(
        crearCarta("Red Dragon","Inglés","Thomas Harris","Amazing Thriller"),
        crearCarta("Blue Dragon","Inglés","Thomas Harris","Amazing Thriller")
        );
        add(cardLayout);
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
}
