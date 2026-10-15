package airbnb.pagos;

import airbnb.base.IMenu;
import airbnb.reservas.POJOReserva;
import airbnb.reservas.ServicioReservas;

import java.util.List;
import java.util.Scanner;

public class MenuPagos implements IMenu {
    private ServicioPagos _servicio;
    private ServicioReservas _reservas;

    public MenuPagos(ServicioPagos servicio, ServicioReservas reservas) {
        this._servicio = servicio;
        this._reservas = reservas;
    }

    @Override
    public String getTitulo() { return "Pagos"; }

    @Override
    public void mostrar(Scanner sc) {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println();
            System.out.println("--- Pagos ---");
            System.out.println("1. Pagar una reserva");
            System.out.println("2. Listar pagos");
            System.out.println("0. Volver");
            opcion = leerNumero(sc, "Opción: ");

            if (opcion == 1) {
                pagarReserva(sc);
            } 
            else 
                if (opcion == 2) {
                listarPagos();
            } 
            else 
                if (opcion != 0) {
                System.out.println("Opción no válida.");
            }
        }
    }

    private void pagarReserva(Scanner sc) {
            int idReserva = leerNumero(sc, "Id de la reserva: ");
            POJOReserva reserva = _reservas.buscarPorId(idReserva);
            if ( reserva == null) {
                System.out.println("Error: no existe una reserva con id " + idReserva + ".");
                return;
        }

        System.out.println("Total de la reserva: $" + reserva.calcularTotal());

        System.out.println("Método de pago: 1. Tarjeta  2. Transferencia");
        int tipo = leerNumero(sc, "Opción: ");

        IMetodoPago metodo;
        if (tipo == 1) {
            System.out.print("Número de tarjeta (16 dígitos): ");
            metodo = new PagoTarjeta(sc.nextLine().trim());
        } else if (tipo == 2) {
            System.out.print("CLABE (18 dígitos): ");
            metodo = new PagoTransferencia(sc.nextLine().trim());
        } else {
            System.out.println("Error: método de pago no válido.");
            return;
        }

        POJOPago pago = _servicio.pagar(reserva, metodo);
        if (pago == null) {
            System.out.println("Error: la reserva no está pendiente o los datos de pago no son válidos.");
        } else {
            System.out.println("Pago realizado. Monto cobrado (con comisión): $" + pago.getMonto());
            System.out.println("Estado de la reserva: " + reserva.getEstado());
        }
    }
    private void listarPagos() {
        List<POJOPago> pagos = _servicio.listar();
        if (pagos.isEmpty()) {
            System.out.println("No hay pagos registrados.");
        } else {
            for (POJOPago p : pagos) {
                System.out.println(p);
            }
        }
    }

    private int leerNumero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: escribe un número.");
            }
        }
    }
}