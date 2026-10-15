
import airbnb.base.IMenu;
import airbnb.busqueda.MenuBusqueda;
import airbnb.busqueda.ServicioBusqueda;
import airbnb.pagos.MenuPagos;
import airbnb.pagos.ServicioPagos;
import airbnb.propiedades.MenuPropiedades;
import airbnb.propiedades.ServicioPropiedades;
import airbnb.reportes.MenuReportes;
import airbnb.reportes.ReporteIngresos;
import airbnb.reportes.ReporteOcupacion;
import airbnb.reportes.ServicioReportes;
import airbnb.resenas.MenuResenas;
import airbnb.resenas.ServicioResenas;
import airbnb.reservas.MenuReservas;
import airbnb.reservas.ServicioReservas;
import airbnb.usuarios.MenuUsuarios;
import airbnb.usuarios.ServicioUsuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ServicioUsuarios usuarios = new ServicioUsuarios();
        ServicioPropiedades propiedades = new ServicioPropiedades();
        ServicioReservas reservas = new ServicioReservas();
        ServicioPagos pagos = new ServicioPagos();
        ServicioResenas resenas = new ServicioResenas();
        ServicioBusqueda busqueda = new ServicioBusqueda(propiedades);
        ServicioReportes reportes = new ServicioReportes();
        reportes.registrar(new ReporteIngresos(pagos));
        reportes.registrar(new ReporteOcupacion(reservas));

        List<IMenu> menus = new ArrayList<>();
        menus.add(new MenuUsuarios(usuarios));
        menus.add(new MenuPropiedades(propiedades, usuarios));
        menus.add(new MenuReservas(reservas, propiedades, usuarios));
        menus.add(new MenuPagos(pagos, reservas));
        menus.add(new MenuResenas(resenas, reservas));
        menus.add(new MenuBusqueda(busqueda));
        menus.add(new MenuReportes(reportes));

        int opcion = -1;
        while (opcion != 0) {
            System.out.println();
            System.out.println("===== Airbnb consola =====");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getTitulo());
            }
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }
            if (opcion >= 1 && opcion <= menus.size()) {
                try {
                    menus.get(opcion - 1).mostrar(sc);
                } catch (UnsupportedOperationException e) {
                    System.out.println("Pendiente de implementar: " + e.getMessage());
                }
            } else if (opcion != 0) {
                System.out.println("Opción no válida.");
            }
        }
        System.out.println("Hasta luego.");
    }
}

