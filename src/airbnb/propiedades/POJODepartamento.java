package airbnb.propiedades;
import airbnb.usuarios.POJOAnfitrion;

public class POJODepartamento extends POJOPropiedad {
    private double _descuentoSemanal;

    public POJODepartamento(int id, String titulo, String ciudad, double precioNoche, int capacidad,
            POJOAnfitrion anfitrion, double descuentoSemanal) {
        super(id, titulo, ciudad, precioNoche, capacidad, anfitrion);
        this._descuentoSemanal = descuentoSemanal;
    }

    public double getDescuentoSemanal() { return _descuentoSemanal; }

    @Override
    public double calcularPrecio(int noches) {

        double subtotal = 0;

        //throw new UnsupportedOperationException("TODO alumno 2: POJODepartamento.calcularPrecio");
        if(noches < 7 ) {
            subtotal = precioNoche* noches;
            return subtotal;
        }

        if (noches > 7){
            
            subtotal = ((precioNoche)*(noches));
            subtotal = subtotal - (subtotal*_descuentoSemanal);
            return subtotal;
        }
        else{
            subtotal = 0;
            return subtotal;
        }
    }
}