
package airbnb.resenas;

import airbnb.base.IMenu;
import airbnb.reservas.POJOReserva;
import airbnb.reservas.ServicioReservas;

import java.util.Scanner;

public class MenuResenas implements IMenu {
    private ServicioResenas _servicio;
    private ServicioReservas _reservas;

    public MenuResenas(ServicioResenas servicio, ServicioReservas reservas) {
        this._servicio = servicio;
        this._reservas = reservas;
    }

    @Override
    public String getTitulo() {
        return "Reseñas";
    }

    @Override
    public void mostrar(Scanner sc) {
        int opcion = -1;

        do {
            System.out.println("\n=== MENÚ DE RESEÑAS ===");
            System.out.println("1. Reseñar propiedad");
            System.out.println("2. Reseñar anfitrión");
            System.out.println("3. Listar reseñas");
            System.out.println("4. Ver promedio de una propiedad");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número válido.");
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1:
                case 2:
                    try {
                        System.out.print("ID de la reserva: ");
                        int idReserva = Integer.parseInt(sc.nextLine().trim());

                        POJOReserva reserva = _reservas.buscarPorId(idReserva);

                        if (reserva == null) {
                            System.out.println("Error: la reserva no existe.");
                            break;
                        }

                        System.out.print("Calificación (1 a 5): ");
                        int calificacion = Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Comentario: ");
                        String comentario = sc.nextLine();

                        int nuevoId = _servicio.listar().size() + 1;

                        POJOResena resena;

                        if (opcion == 1) {
                            resena = new POJOResenaPropiedad(
                                    nuevoId, reserva, calificacion, comentario);
                        } else {
                            resena = new POJOResenaAnfitrion(
                                    nuevoId, reserva, calificacion, comentario);
                        }

                        if (_servicio.guardar(resena)) {
                            System.out.println("Reseña guardada correctamente.");
                        } else {
                            System.out.println(
                                    "No se pudo guardar la reseña. " +
                                    "La reserva debe estar completada, " +
                                    "la reseña no debe estar repetida " +
                                    "y los datos deben ser válidos.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Error: debe ingresar un número válido.");
                    }
                    break;

                case 3:
                    if (_servicio.listar().isEmpty()) {
                        System.out.println("No hay reseñas registradas.");
                    } else {
                        System.out.println("\n=== RESEÑAS REGISTRADAS ===");

                        for (POJOResena resena : _servicio.listar()) {
                            System.out.println(resena);
                        }
                    }
                    break;

                case 4:
                    try {
                        System.out.print("ID de la reserva: ");
                        int idReserva = Integer.parseInt(sc.nextLine().trim());

                        POJOReserva reserva = _reservas.buscarPorId(idReserva);

                        if (reserva == null) {
                            System.out.println("Error: la reserva no existe.");
                            break;
                        }

                        double promedio = _servicio.promedioPropiedad(
                                reserva.getPropiedad());

                        System.out.printf(
                                "Promedio de la propiedad: %.1f%n",
                                promedio);

                    } catch (NumberFormatException e) {
                        System.out.println("Error: debe ingresar un número válido.");
                    }
                    break;

                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 0);
    }
}
