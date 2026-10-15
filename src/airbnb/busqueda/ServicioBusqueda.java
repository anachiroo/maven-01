package airbnb.busqueda;

import airbnb.propiedades.POJOPropiedad;
import airbnb.propiedades.ServicioPropiedades;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServicioBusqueda {
    private ServicioPropiedades _propiedades;

    public ServicioBusqueda(ServicioPropiedades propiedades) {
        this._propiedades = propiedades;
    }

    public List<POJOPropiedad> buscar(List<IFiltroBusqueda> filtros) {
         List<POJOPropiedad> resultado = new ArrayList<>();

  for (POJOPropiedad propiedad : _propiedades.listarDisponibles()) {

            boolean cumple = true;

            if (filtros != null) {
                for (IFiltroBusqueda filtro : filtros) {
                    if (!filtro.cumple(propiedad)) {
                        cumple = false;
                    }
                }
            }

            if (cumple) {
                resultado.add(propiedad);
            }
        }

        return resultado;
    }

    public List<POJOPropiedad> ordenarPorPrecio(List<POJOPropiedad> lista) {

        List<POJOPropiedad> resultado = new ArrayList<>(lista);

        resultado.sort(Comparator.comparingDouble(POJOPropiedad::getPrecioNoche));

        return resultado;
    }
    
}
