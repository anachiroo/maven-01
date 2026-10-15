
package airbnb.resenas;

import airbnb.reservas.POJOReserva;

public class POJOResenaPropiedad extends POJOResena {
    public POJOResenaPropiedad(int id, POJOReserva reserva, int calificacion, String comentario) {
        super(id, reserva, calificacion, comentario);
    }

    @Override
    public String getEvaluado() {
        return reserva.getPropiedad().getTitulo();
    }
}
