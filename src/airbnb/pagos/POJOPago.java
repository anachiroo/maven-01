package airbnb.pagos;

import airbnb.reservas.POJOReserva;

public class POJOPago {
    private int _id;
    private POJOReserva _reserva;
    private IMetodoPago _metodo;
    private double _monto;

    public POJOPago(int id, POJOReserva reserva, IMetodoPago metodo, double monto) {
        this._id = id;
        this._reserva = reserva;
        this._metodo = metodo;
        this._monto = monto;
    }

    public int getId() { return _id; }
    public POJOReserva getReserva() { return _reserva; }
    public IMetodoPago getMetodo() { return _metodo; }
    public double getMonto() { return _monto; }

    @Override
    public String toString() {
        return _id + " - reserva " + _reserva.getId() + ", $" + _monto + " (" + _metodo + ")";
    }
}
