package sistema.biblioteca.Servicio.PrestaServicio;

import sistema.biblioteca.Entidad.BibliotecaMaterial;

import java.util.List;

public interface PrestaServicio {
    public boolean registrarPrestamo(String username, List<BibliotecaMaterial> materiales);
}
