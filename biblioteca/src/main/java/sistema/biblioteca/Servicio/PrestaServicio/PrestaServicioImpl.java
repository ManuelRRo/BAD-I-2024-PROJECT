package sistema.biblioteca.Servicio.PrestaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.biblioteca.Entidad.BibliotecaMaterial;
import sistema.biblioteca.Repositorio.PrestaRepositorio;
import sistema.biblioteca.Servicio.Miembro.MiembroServicio;

import java.util.List;
@Service
public class PrestaServicioImpl implements PrestaServicio{

    @Autowired
    private MiembroServicio miembroServicio;
    @Autowired
    private PrestaRepositorio prestaRepositorio;
    @Override
    public boolean registrarPrestamo(String username, List<BibliotecaMaterial> materiales) {
        System.out.println("Registrar Prestamo: "+username);
        //System.out.println("Miembro: "+miembroServicio.econtrarCarnetPorUsername(username));
        String carnet = miembroServicio.econtrarCarnetPorUsername(username);

        if(materiales.size() != 0){
            for (BibliotecaMaterial material : materiales) {
//                System.out.println("Titulo Material"+material.getTitulo());
//            System.out.println("vALOR CARNET" + carnet);
               prestaRepositorio.registrarPrestamos(carnet,material.getId_material_biblioteca());
            }
            return true;
        }
        return false;
    }
}
