package airbnb.reservas;

import airbnb.propiedades.POJOPropiedad;
import airbnb.usuarios.POJOHuesped;

import java.util.ArrayList;
import java.util.List;

public class ServicioReservas {
    private List<POJOReserva> _reservas = new ArrayList<>();

    public boolean guardar(POJOReserva obj) {
        throw new UnsupportedOperationException("TODO alumno 3: guardar");
    }

    public POJOReserva buscarPorId(int id) {
        throw new UnsupportedOperationException("TODO alumno 3: buscarPorId");
    }

    public List<POJOReserva> listar() {
        throw new UnsupportedOperationException("TODO alumno 3: listar");
    }

    public POJOReserva reservar(POJOHuesped h, POJOPropiedad p, int noches, int numHuespedes, IPoliticaCancelacion politica) {
        throw new UnsupportedOperationException("TODO alumno 3: reservar");
    }

    public double cancelar(int id, int diasAntes) {
        throw new UnsupportedOperationException("TODO alumno 3: cancelar");
    }

    public boolean completar(int id) {
        throw new UnsupportedOperationException("TODO alumno 3: completar");
    }
}
