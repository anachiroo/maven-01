
package airbnb.resenas;

import airbnb.reservas.POJOReserva;

public class POJOResenaAnfitrion extends POJOResena {
    public POJOResenaAnfitrion(int id, POJOReserva reserva, int calificacion, String comentario) {
        super(id, reserva, calificacion, comentario);
    }

    @Override
    public String getEvaluado() {
        return reserva.getPropiedad().getAnfitrion().getNombre();
    }
}
