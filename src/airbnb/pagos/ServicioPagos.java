package airbnb.pagos;

import airbnb.reservas.POJOReserva;
import airbnb.reservas.POJOReserva;
import airbnb.reservas.EstadoReserva;

import java.util.ArrayList;
import java.util.List;

public class ServicioPagos {
    private List<POJOPago> _pagos = new ArrayList<>();

    public boolean guardar(POJOPago obj) {
        if (obj == null) {
            return false;
        }
        if (buscarPorId(obj.getId()) != null) {
            return false;
        }
        if (obj.getReserva() == null || obj.getMetodo() == null || obj.getMonto() <= 0) {
            return false;
        }

        _pagos.add(obj);
        return true;
    }

    public POJOPago buscarPorId(int id) {
        for (POJOPago p : _pagos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public List<POJOPago> listar() {
        return new ArrayList<>(_pagos);
    }

    public POJOPago pagar(POJOReserva r, IMetodoPago m) {
        if (r == null || m == null) {
            return null;
        }
        if (r.getEstado() != EstadoReserva.PENDIENTE) {
            return null;
        }
        if (!m.validar()) {
            return null;
        }
        double total = r.calcularTotal();
        double monto = total + m.calcularComision(total);
        POJOPago pago = new POJOPago(_pagos.size() + 1, r, m, monto);
        guardar(pago);
        r.setEstado(EstadoReserva.CONFIRMADA);
        return pago;
    }
}
