package airbnb.busqueda;

import airbnb.propiedades.POJOPropiedad;

public interface IFiltroBusqueda {
    boolean cumple(POJOPropiedad p);
}
