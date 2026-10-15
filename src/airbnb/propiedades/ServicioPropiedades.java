package airbnb.propiedades;
import java.util.ArrayList;
import java.util.List;

public class ServicioPropiedades {
    private List<POJOPropiedad> _propiedades = new ArrayList<>();

    public boolean guardar(POJOPropiedad obj) {

        if (obj == null) {
            return false;
        }

        if (buscarPorId(obj.getId()) != null) {
            return false;
        }

        if (obj.getAnfitrion() == null || 
            obj.getTitulo() == null || obj.getTitulo().trim().isEmpty() || 
            obj.getPrecioNoche() <= 0 || 
            obj.getCapacidad() <= 0) {
            return false;
        }

        _propiedades.add(obj);
        return true;
    }

    public POJOPropiedad buscarPorId(int id) {
        for (POJOPropiedad propiedad : _propiedades) {
            if (propiedad.getId() == id) {
                return propiedad;
            }
        }
        return null;
    }

    public List<POJOPropiedad> listar() {
        return new ArrayList<>(_propiedades);
    }

    public List<POJOPropiedad> listarDisponibles() {
        List<POJOPropiedad> disponibles = new ArrayList<>();
        for (POJOPropiedad propiedad : _propiedades) {
            if (propiedad.isDisponible()) {
                disponibles.add(propiedad);
            }
        }
        return disponibles;
    }
}