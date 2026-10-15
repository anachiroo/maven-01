
package airbnb.resenas;

import airbnb.reservas.POJOReserva;

public abstract class POJOResena {
    protected int id;
    protected POJOReserva reserva;
    protected int calificacion;
    protected String comentario;

    public POJOResena(int id, POJOReserva reserva, int calificacion, String comentario) {
        this.id = id;
        this.reserva = reserva;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public abstract String getEvaluado();

    public boolean esValida() {
        return calificacion >= 1 && calificacion <= 5
                && comentario != null
                && !comentario.trim().isEmpty();
    }

    public int getId() { return id; }
    public POJOReserva getReserva() { return reserva; }
    public int getCalificacion() { return calificacion; }
    public String getComentario() { return comentario; }

    @Override
    public String toString() {
        return id + " - " + getEvaluado() + ": "
                + calificacion + "/5 - " + comentario;
    }
}
