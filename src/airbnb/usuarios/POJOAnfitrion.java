package airbnb.usuarios;

public class POJOAnfitrion extends POJOUsuario {
    public POJOAnfitrion(int id, String nombre, String email) {
        super(id, nombre, email);
    }

    @Override
    public String getRol() {
        return "Anfitrion";
    }
}
