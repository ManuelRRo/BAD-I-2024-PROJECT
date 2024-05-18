package sistema.biblioteca.Vistas;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.spring.security.AuthenticationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import sistema.biblioteca.Vistas.CatalogoLibro.Catalogo;
import sistema.biblioteca.Vistas.ListPrestamo.ListarPrestamos;


@CssImport("./styles/shared-styles.css")
public class MainLayout extends AppLayout {

    private final transient AuthenticationContext authContext;
    public MainLayout(AuthenticationContext authContext) {
        this.authContext = authContext;
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Sistema Bibliotecario");
        logo.addClassName("logo");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //H2 Credenciales = new H2();

        //logout button


        //HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);//
        HorizontalLayout
                header =
                authContext.getAuthenticatedUser(UserDetails.class)
                        .map(user -> {
                            Button logout = new Button("Logout", click ->
                                    this.authContext.logout());
                            Span loggedUser = new Span("Welcome " + user.getUsername());
                            return new HorizontalLayout(new DrawerToggle(),logo, loggedUser, logout);
                        }).orElseGet(() -> new HorizontalLayout(logo));

        header.setDefaultVerticalComponentAlignment(
                FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassName("header");
        addToNavbar(header);
    }

    private void createDrawer() {
        //Cambiar nombre de ListEstudiante
        RouterLink listLink = new RouterLink("PRESTAMOS", ListarPrestamos.class);
        RouterLink catalogo = new RouterLink("CATALOGO", Catalogo.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());
        catalogo.setHighlightCondition(HighlightConditions.sameLocation());
        addToDrawer(new VerticalLayout(listLink,catalogo));
    }
}
