package airbnb.reservas;

public class Estricta implements IPoliticaCancelacion {
    @Override
    public double calcularReembolso(double total, int diasAntes) {
        throw new UnsupportedOperationException("TODO alumno 3: Estricta.calcularReembolso");
    }
}
