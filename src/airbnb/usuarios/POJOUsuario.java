package airbnb.usuarios;

public abstract class POJOUsuario {
    protected int id;
    protected String nombre;
    protected String email;

    public POJOUsuario(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public abstract String getRol();

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return id + " - " + nombre + " (" + getRol() + ") " + email;
    }
}
