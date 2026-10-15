package airbnb.reportes;

import airbnb.base.IMenu;

import java.util.Scanner;

public class MenuReportes implements IMenu {
    private ServicioReportes _servicio;

    public MenuReportes(ServicioReportes servicio) {
        this._servicio = servicio;
    }

    @Override
    public String getTitulo() { return "Reportes"; }

    @Override
    public void mostrar(Scanner sc) {
        throw new UnsupportedOperationException("TODO alumno 7: MenuReportes.mostrar");
    }
}
