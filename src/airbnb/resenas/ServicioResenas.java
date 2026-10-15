
package airbnb.resenas;

import airbnb.propiedades.POJOPropiedad;
import airbnb.reservas.EstadoReserva;

import java.util.ArrayList;
import java.util.List;

public class ServicioResenas {
    private List<POJOResena> _resenas = new ArrayList<>();

    public boolean guardar(POJOResena obj) {

        if (obj == null || !obj.esValida()) {
            return false;
        }

        if (obj.getReserva() == null ||
            obj.getReserva().getEstado() != EstadoReserva.COMPLETADA) {
            return false;
        }

        if (buscarPorId(obj.getId()) != null) {
            return false;
        }

        for (POJOResena resena : _resenas) {
            if (resena.getReserva() == obj.getReserva()
                    && resena.getClass() == obj.getClass()) {
                return false;
            }
        }

        _resenas.add(obj);
        return true;
    }

    public POJOResena buscarPorId(int id) {

        for (POJOResena resena : _resenas) {
            if (resena.getId() == id) {
                return resena;
            }
        }

        return null;
    }

    public List<POJOResena> listar() {
        return new ArrayList<>(_resenas);
    }

    public double promedioPropiedad(POJOPropiedad p) {

        if (p == null) {
            return 0;
        }

        int suma = 0;
        int cantidad = 0;

        for (POJOResena resena : _resenas) {

            if (resena instanceof POJOResenaPropiedad
                    && resena.getReserva().getPropiedad() == p) {

                suma += resena.getCalificacion();
                cantidad++;
            }
        }

        if (cantidad == 0) {
            return 0;
        }

        return (double) suma / cantidad;
    }
}

