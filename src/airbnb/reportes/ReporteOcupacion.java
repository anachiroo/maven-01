package airbnb.reportes;

import airbnb.reservas.ServicioReservas;

public class ReporteOcupacion implements IReporte {
    private ServicioReservas _reservas;

    public ReporteOcupacion(ServicioReservas reservas) {
        this._reservas = reservas;
    }

    @Override
    public String getTitulo() { return "Ocupación"; }

    @Override
    public String generar() {
        throw new UnsupportedOperationException("TODO alumno 7: ReporteOcupacion.generar");
    }
}
