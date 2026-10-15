package airbnb.reportes;

import airbnb.pagos.ServicioPagos;

public class ReporteIngresos implements IReporte {
    private ServicioPagos _pagos;

    public ReporteIngresos(ServicioPagos pagos) {
        this._pagos = pagos;
    }

    @Override
    public String getTitulo() { return "Ingresos"; }

    @Override
    public String generar() {
        throw new UnsupportedOperationException("TODO alumno 7: ReporteIngresos.generar");
    }
}
