package airbnb.busqueda;

import airbnb.propiedades.POJOPropiedad;

public class FiltroCiudad implements IFiltroBusqueda {
    private String _ciudad;

    public FiltroCiudad(String ciudad) {
        this._ciudad = ciudad;
    }

    @Override
    public boolean cumple(POJOPropiedad p) {
    if (p == null) {
        return false;
    }

    String ciudad = p.getCiudad().trim();
    String buscada = _ciudad.trim();

    if (ciudad.equalsIgnoreCase(buscada)) {
        return true;
    }

    return false;
}
}


