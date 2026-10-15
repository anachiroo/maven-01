package airbnb.propiedades;

import airbnb.usuarios.POJOAnfitrion;

public class POJOCasa extends POJOPropiedad {
    private double _cargoLimpieza;

    public POJOCasa(int id, String titulo, String ciudad, double precioNoche, int capacidad,
            POJOAnfitrion anfitrion, double cargoLimpieza) {
        super(id, titulo, ciudad, precioNoche, capacidad, anfitrion);
        this._cargoLimpieza = cargoLimpieza;
    }

    public double getCargoLimpieza() { return _cargoLimpieza; }

    @Override
    public double calcularPrecio(int noches) {
        double subtotal = 0;

        /*throw new UnsupportedOperationException("TODO alumno 2: POJOCasa.calcularPrecio");*/

        
        if(noches < 7 ){
        subtotal = (precioNoche)*(noches)+ _cargoLimpieza;
        return subtotal;
        }

        if (noches > 7){
            double _descuentoSemanal= 0.10;
            subtotal = ((precioNoche)*(noches)+_cargoLimpieza);
            subtotal = subtotal - (subtotal*_descuentoSemanal);
            return subtotal;
        }
        else{
            subtotal = 0;
            return subtotal;
        }
    }
}
