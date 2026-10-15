package airbnb.propiedades;

import airbnb.usuarios.POJOAnfitrion;

public abstract class POJOPropiedad {
    protected int id;
    protected String titulo;
    protected String ciudad;
    protected double precioNoche;
    protected int capacidad;
    protected boolean disponible;
    protected POJOAnfitrion anfitrion;

    public POJOPropiedad(int id, String titulo, String ciudad, double precioNoche, int capacidad, POJOAnfitrion anfitrion) {
        this.id = id;
        this.titulo = titulo;
        this.ciudad = ciudad;
        this.precioNoche = precioNoche;
        this.capacidad = capacidad;
        this.anfitrion = anfitrion;
        this.disponible = true;
    }

    public abstract double calcularPrecio(int noches);

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getCiudad() { return ciudad; }
    public double getPrecioNoche() { return precioNoche; }
    public int getCapacidad() { return capacidad; }
    public boolean isDisponible() { return disponible; }
    public POJOAnfitrion getAnfitrion() { return anfitrion; }

    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return id + " - " + titulo;
    }
}
