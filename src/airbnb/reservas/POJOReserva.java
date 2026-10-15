package airbnb.reservas;

import airbnb.propiedades.POJOPropiedad;
import airbnb.usuarios.POJOHuesped;

public class POJOReserva {
    private int _id;
    private POJOHuesped _huesped;
    private POJOPropiedad _propiedad;
    private int _noches;
    private int _numHuespedes;
    private EstadoReserva _estado;
    private IPoliticaCancelacion _politica;

    public POJOReserva(int id, POJOHuesped huesped, POJOPropiedad propiedad, int noches,
            int numHuespedes, IPoliticaCancelacion politica) {
        this._id = id;
        this._huesped = huesped;
        this._propiedad = propiedad;
        this._noches = noches;
        this._numHuespedes = numHuespedes;
        this._politica = politica;
        this._estado = EstadoReserva.PENDIENTE;
    }

    public double calcularTotal() {
        throw new UnsupportedOperationException("TODO alumno 3: calcularTotal");
    }

    public int getId() { return _id; }
    public POJOHuesped getHuesped() { return _huesped; }
    public POJOPropiedad getPropiedad() { return _propiedad; }
    public int getNoches() { return _noches; }
    public int getNumHuespedes() { return _numHuespedes; }
    public EstadoReserva getEstado() { return _estado; }
    public IPoliticaCancelacion getPolitica() { return _politica; }

    public void setEstado(EstadoReserva estado) { this._estado = estado; }

    @Override
    public String toString() {
        return _id + " - " + _propiedad.getTitulo() + ", " + _noches + " noches [" + _estado + "]";
    }
}
