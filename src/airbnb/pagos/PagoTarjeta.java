package airbnb.pagos;

public class PagoTarjeta implements IMetodoPago {
    private String _numeroTarjeta;

    public PagoTarjeta(String numeroTarjeta) {
        this._numeroTarjeta = numeroTarjeta;
    }

    @Override
    public boolean validar() {
        return _numeroTarjeta != null && _numeroTarjeta.matches("\\d{16}");
    }

    @Override
    public double calcularComision(double monto) {
        return monto * 3.5 / 100;
    }

    @Override
    public String toString() { return "Tarjeta"; }
}
