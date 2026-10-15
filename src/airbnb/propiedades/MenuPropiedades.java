package airbnb.propiedades;
import airbnb.base.IMenu;
import airbnb.usuarios.POJOAnfitrion;
import airbnb.usuarios.ServicioUsuarios;

import java.util.List;
import java.util.Scanner;

public class MenuPropiedades implements IMenu {
    private ServicioPropiedades _servicio;
    private ServicioUsuarios _usuarios;

    public MenuPropiedades(ServicioPropiedades servicio, ServicioUsuarios usuarios) {
        this._servicio = servicio;
        this._usuarios = usuarios;
    }

    @Override
    public String getTitulo() { return "Propiedades"; }

    @Override
    public void mostrar(Scanner sc) {
        int opcion = -1;

        do {
            System.out.println("\n--- Menú Propiedades ---");
            System.out.println("1. Publicar casa");
            System.out.println("2. Publicar departamento");
            System.out.println("3. Listar todas");
            System.out.println("4. Listar disponibles");
            System.out.println("0. Volver");
            System.out.print("Elija una opción: ");

            String entrada = sc.nextLine();
            try {
                opcion = Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    publicarCasa(sc);
                    break;
                case 2:
                    publicarDepartamento(sc);
                    break;
                case 3:
                    listarTodas();
                    break;
                case 4:
                    listarDisponibles();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 0);
    }

    private void publicarCasa(Scanner sc) {
        System.out.println("\n--- Publicar Nueva Casa ---");
        
        System.out.print("Ingrese el email del anfitrión: ");
        String email = sc.nextLine();
        Object usuario = _usuarios.buscarPorEmail(email);
        
        if (!(usuario instanceof POJOAnfitrion)) {
            System.out.println("Error: El usuario no existe o no es un anfitrión válido.");
            return;
        }
        POJOAnfitrion anfitrion = (POJOAnfitrion) usuario;

        System.out.print("Título: ");
        String titulo = sc.nextLine();
        
        System.out.print("Ciudad: ");
        String ciudad = sc.nextLine();

        double precioNoche = leerDouble(sc, "Precio por noche: ");
        if (precioNoche < 0) return;

        int capacidad = leerInt(sc, "Capacidad de personas: ");
        if (capacidad < 0) return;

        double cargoLimpieza = leerDouble(sc, "Cargo de limpieza: ");
        if (cargoLimpieza < 0) return;

        int nuevoId = _servicio.listar().size() + 1;
        
        POJOCasa casa = new POJOCasa(nuevoId, titulo, ciudad, precioNoche, capacidad, anfitrion, cargoLimpieza);

        boolean guardado = _servicio.guardar(casa);
        if (guardado) {
            System.out.println("Casa publicada con éxito.");
        } else {
            System.out.println("Error: No se pudo guardar la casa.");
        }
    }

    private void publicarDepartamento(Scanner sc) {
        System.out.println("\n--- Publicar Nuevo Departamento ---");
        
        System.out.print("Ingrese el email del anfitrión: ");
        String email = sc.nextLine();
        Object usuario = _usuarios.buscarPorEmail(email);
        
        if (!(usuario instanceof POJOAnfitrion)) {
            System.out.println("Error: El usuario no existe o no es un anfitrión válido.");
            return;
        }
        POJOAnfitrion anfitrion = (POJOAnfitrion) usuario;

        System.out.print("Título: ");
        String titulo = sc.nextLine();
        
        System.out.print("Ciudad: ");
        String ciudad = sc.nextLine();

        double precioNoche = leerDouble(sc, "Precio por noche: ");
        if (precioNoche < 0) return;

        int capacidad = leerInt(sc, "Capacidad de personas: ");
        if (capacidad < 0) return;

        double descuentoPorcentaje = leerDouble(sc, "Descuento en porcentaje (ej: 10 para 10%): ");
        if (descuentoPorcentaje < 0) return;
        double descuento = descuentoPorcentaje / 100.0;

        int nuevoId = _servicio.listar().size() + 1;
        
        POJODepartamento depto = new POJODepartamento(nuevoId, titulo, ciudad, precioNoche, capacidad, anfitrion, descuento);

        boolean guardado = _servicio.guardar(depto);
        if (guardado) {
            System.out.println("Departamento publicado con éxito.");
        } else {
            System.out.println("Error: No se pudo guardar el departamento.");
        }
    }

    private void listarTodas() {
        System.out.println("\n--- Lista de Todas las Propiedades ---");
        List<POJOPropiedad> lista = _servicio.listar();
        if (lista.isEmpty()) {
            System.out.println("(No hay propiedades registradas)");
            return;
        }
        for (POJOPropiedad p : lista) {
            System.out.println("- ID: " + p.getId() + " | Título: " + p.getTitulo() + " | Ciudad: " + p.getCiudad() + 
                               " | Precio: $" + p.getPrecioNoche() + " | Disponible: " + p.isDisponible());
        }
    }

    private void listarDisponibles() {
        System.out.println("\n--- Lista de Propiedades Disponibles ---");
        List<POJOPropiedad> lista = _servicio.listarDisponibles();
        if (lista.isEmpty()) {
            System.out.println("(No hay propiedades disponibles)");
            return;
        }
        for (POJOPropiedad p : lista) {
            System.out.println("- ID: " + p.getId() + " | Título: " + p.getTitulo() + " | Ciudad: " + p.getCiudad() + 
                               " | Precio: $" + p.getPrecioNoche());
        }
    }

    private int leerInt(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número entero válido.");
            }
        }
    }

    private double leerDouble(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }
    }
}