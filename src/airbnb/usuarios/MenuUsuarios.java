package airbnb.usuarios;

import airbnb.base.IMenu;

import java.util.Scanner;

public class MenuUsuarios implements IMenu {
    private ServicioUsuarios _servicio;

    public MenuUsuarios(ServicioUsuarios servicio) {
        this._servicio = servicio;
    }

    @Override
    public String getTitulo() {
        return "Usuarios";
    }

    @Override
    public void mostrar(Scanner sc) {
        String opcion;

        do {
            System.out.println("\n--- Menú Usuarios ---");
            System.out.println("1. Registrar huesped");
            System.out.println("2. Registrar anfitrion");
            System.out.println("3. Listar usuarios");
            System.out.println("0. Volver");
            System.out.print("Elige una opción: ");

            opcion = sc.nextLine();

            switch (opcion) {
                case "1": {
                    int id = _servicio.listar().size() + 1;

                    System.out.print("Nombre del huesped: ");
                    String nombre = sc.nextLine();

                    System.out.print("Email del huesped: ");
                    String email = sc.nextLine();

                    POJOHuesped huesped = new POJOHuesped(id, nombre, email);

                    if (_servicio.guardar(huesped)) {
                        System.out.println("Huesped registrado correctamente.");
                    } else {
                        System.out.println("Error: el email no es válido o ya está registrado.");
                    }
                    break;
                }

                case "2": {
                    int id = _servicio.listar().size() + 1;

                    System.out.print("Nombre del anfitrion: ");
                    String nombre = sc.nextLine();

                    System.out.print("Email del anfitrion: ");
                    String email = sc.nextLine();

                    POJOAnfitrion anfitrion = new POJOAnfitrion(id, nombre, email);

                    if (_servicio.guardar(anfitrion)) {
                        System.out.println("Anfitrion registrado correctamente.");
                    } else {
                        System.out.println("Error: el email no es valido o ya está registrado.");
                    }
                    break;
                }

                case "3": {
                    if (_servicio.listar().isEmpty()) {
                        System.out.println("No hay usuarios registrados.");
                    } else {
                        for (POJOUsuario usuario : _servicio.listar()) {
                            System.out.println(usuario.toString());
                        }
                    }
                    break;
                }

                case "0":
                    System.out.println("Volviendo al menú anterior...");
                    break;

                default:
                    System.out.println("Opción no valida. Escribe 0, 1, 2 o 3.");
                    break;
            }
        } while (!opcion.equals("0"));
    }

}
