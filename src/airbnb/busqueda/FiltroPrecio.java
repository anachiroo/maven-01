package airbnb.busqueda;

import airbnb.propiedades.POJOPropiedad;

public class FiltroPrecio implements IFiltroBusqueda {
    private double _min;
    private double _max;

    public FiltroPrecio(double min, double max) {
        this._min = min;
        this._max = max;
    }

@Override
    public boolean cumple(POJOPropiedad p) {
        if (p == null) {
            return false;
        }

        double precio = p.getPrecioNoche();

        if (precio >= _min && precio <= _max) {
            return true;
        }

        return false;
    }
}
