package airbnb.reportes;

import java.util.ArrayList;
import java.util.List;

public class ServicioReportes {
    private List<IReporte> _reportes = new ArrayList<>();

    public void registrar(IReporte r) {
        _reportes.add(r);
    }

    public List<IReporte> getReportes() { return _reportes; }

    public String ejecutar(int indice) {
        throw new UnsupportedOperationException("TODO alumno 7: ejecutar");
    }

    public boolean exportar(int indice, String archivo) {
        throw new UnsupportedOperationException("TODO alumno 7: exportar");
    }
}
