package airbnb.busqueda;
import airbnb.base.IMenu;
import airbnb.propiedades.POJOPropiedad;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuBusqueda implements IMenu {

    private ServicioBusqueda _servicio;

    public MenuBusqueda(ServicioBusqueda servicio) {
        _servicio = servicio;
    }

    @Override
    public String getTitulo() {
        return "Buscar alojamiento";
    }

    @Override
    public void mostrar(Scanner sc) {

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("1. Buscar alojamiento");
            System.out.println("0. Volver");
            System.out.print("Opcion: ");

            String texto = sc.nextLine();

            try {
                opcion = Integer.parseInt(texto);
            } catch (Exception e) {
                System.out.println("Escribe un numero.");
                continue;
            }

            if (opcion == 1) {

                List<IFiltroBusqueda> filtros = new ArrayList<>();

                System.out.print("Ciudad (Enter para omitir): ");
                String ciudad = sc.nextLine();

                if (!ciudad.isEmpty()) {
                    filtros.add(new FiltroCiudad(ciudad));
                }

                System.out.print("Precio minimo (Enter para omitir): ");
                String minimoTexto = sc.nextLine();

                if (!minimoTexto.isEmpty()) {

                    try {
                        double minimo = Double.parseDouble(minimoTexto);

                        System.out.print("Precio maximo: ");
                        double maximo = Double.parseDouble(sc.nextLine());

                        filtros.add(new FiltroPrecio(minimo, maximo));

                    } catch (Exception e) {
                        System.out.println("Escribe un precio valido.");
                        continue;
                    }
                }

                List<POJOPropiedad> propiedades = _servicio.buscar(filtros);

                propiedades = _servicio.ordenarPorPrecio(propiedades);

                if (propiedades.size() == 0) {

                    System.out.println("No se encontraron propiedades");

                } else {

                    for (POJOPropiedad propiedad : propiedades) {
                        System.out.println(propiedad);
                    }
                }

                System.out.println("Filtros aplicados: " + filtros.size());
                System.out.println("Resultados: " + propiedades.size());
            }

            if (opcion != 0 && opcion != 1) {
                System.out.println("Opcion no valida.");
            }
        }

        System.out.println("Volviendo...");
    }
}
