package airbnb.usuarios;

public class POJOHuesped extends POJOUsuario {
    public POJOHuesped(int id, String nombre, String email) {
        super(id, nombre, email);
    }

    @Override
    public String getRol() {
        return "Huesped";
    }
}
