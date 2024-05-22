package sistema.biblioteca.Vistas.Usuario;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
//import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import sistema.biblioteca.DTO.UsuarioRegistroDTO;
import sistema.biblioteca.Vistas.MainLayout;
import sistema.biblioteca.Entidad.Usuario;
import sistema.biblioteca.Entidad.Idioma;
import sistema.biblioteca.Entidad.Presta;
import sistema.biblioteca.Servicio.UsuarioServicio.UsuarioServicio;

@Route(value = "registrarUsuario", layout = MainLayout.class)
public class Registrar extends VerticalLayout{

    private final UsuarioServicio usuarioServicio;

    @Autowired
    public Registrar(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;

        // Crear un título para el formulario
        H2 titulo = new H2("Registro de Usuario");

        // Crear campos de entrada
        TextField nombreUsuario = new TextField();
        TextField username = new TextField();
        TextField correo = new TextField();
        PasswordField password = new PasswordField();

        // Crear botón de registro
        Button registrarBtn = new Button("Registrar Usuario");

        // Añadir evento al botón
        registrarBtn.addClickListener(event -> {
            UsuarioRegistroDTO usuarioRegistroDTO = new UsuarioRegistroDTO();
            usuarioRegistroDTO.setNombre_usuario(nombreUsuario.getValue());
            usuarioRegistroDTO.setUsername(username.getValue());
            usuarioRegistroDTO.setCorreo(correo.getValue());
            usuarioRegistroDTO.setPassword(password.getValue());

            Usuario usuario = usuarioServicio.save(usuarioRegistroDTO);
            Notification.show("Usuario registrado con ID: " + usuario.getId_usuario());
        });

        // Crear el formulario y añadir los campos y el botón
        FormLayout formLayout = new FormLayout();
        formLayout.addFormItem(nombreUsuario, "Nombre de usuario:");
        formLayout.addFormItem(username, "Username:");
        formLayout.addFormItem(correo, "Correo:");
        formLayout.addFormItem(password, "Contraseña:");

        // Añadir el botón en una línea separada
        VerticalLayout buttonLayout = new VerticalLayout(registrarBtn);
        buttonLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER); // Centrar el botón

        // Añadir el título, el formulario y el botón al layout principal
        add(titulo, formLayout, buttonLayout);

        // Establecer el ancho del formulario
        formLayout.setWidth("600px");
        setHorizontalComponentAlignment(Alignment.CENTER, formLayout, buttonLayout, titulo);
    }
}
