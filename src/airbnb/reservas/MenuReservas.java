package airbnb.reservas;

import airbnb.base.IMenu;
import airbnb.propiedades.ServicioPropiedades;
import airbnb.usuarios.ServicioUsuarios;

import java.util.Scanner;

public class MenuReservas implements IMenu {
    private ServicioReservas _servicio;
    private ServicioPropiedades _propiedades;
    private ServicioUsuarios _usuarios;

    public MenuReservas(ServicioReservas servicio, ServicioPropiedades propiedades, ServicioUsuarios usuarios) {
        this._servicio = servicio;
        this._propiedades = propiedades;
        this._usuarios = usuarios;
    }

    @Override
    public String getTitulo() { return "Reservas"; }

    @Override
    public void mostrar(Scanner sc) {
        throw new UnsupportedOperationException("TODO alumno 3: MenuReservas.mostrar");
    }
}
