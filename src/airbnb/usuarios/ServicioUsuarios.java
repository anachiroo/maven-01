package airbnb.usuarios;

import java.util.ArrayList;
import java.util.List;

public class ServicioUsuarios {
    private List<POJOUsuario> _usuarios = new ArrayList<>();

    public boolean guardar(POJOUsuario obj) {
    if (buscarPorId(obj.getId()) != null) {
        return false;
    }
    else if (obj.getEmail() == null || !obj.getEmail().contains("@")) {
        return false;
    }
    else if (buscarPorEmail(obj.getEmail()) != null) {
        return false;
    }
    else {
        _usuarios.add(obj);
        return true;
    }
}

    public POJOUsuario buscarPorId(int id) {
        for (POJOUsuario u : _usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public List<POJOUsuario> listar() {
        List<POJOUsuario> output = new ArrayList<>();
        output.addAll(_usuarios);
        return output;
    }

    public POJOUsuario buscarPorEmail(String email) {
        for (POJOUsuario u : _usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }
}
