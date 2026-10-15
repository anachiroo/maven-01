package airbnb.pagos;

public interface IMetodoPago {
    boolean validar();
    double calcularComision(double monto);
}
