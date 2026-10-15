package airbnb.pagos;

public class PagoTransferencia implements IMetodoPago {
    private String _clabe;

    public PagoTransferencia(String clabe) {
        this._clabe = clabe;
    }

    @Override
    public boolean validar() {
        return _clabe != null && _clabe.matches("\\d{18}");
       
    }

    @Override
    public double calcularComision(double monto) {
        return 0;
    }

    @Override
    public String toString() { return "Transferencia"; }
}
