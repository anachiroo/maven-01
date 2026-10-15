package airbnb.reservas;

public interface IPoliticaCancelacion {
    double calcularReembolso(double total, int diasAntes);
}
