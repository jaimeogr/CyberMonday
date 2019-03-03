import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Local extends Establecimiento {
    private ArrayList<Venta> ventas = new ArrayList<Venta>();

    public Local(String lugar) {
        super(lugar);
    }

    public Integer ventasConProductoEnPromocion() {
        return ventas.stream().filter(v -> v.alMenosUnProductoEnPromocion()).collect(Collectors.toList()).size();
    }

    public List<Venta> ventasEnDeterminadaFecha(Date date) {
        return ventas.stream().filter(v -> v.getDate().equals(date)).collect(Collectors.toList());
    }

    public Double montoAhorradoPorClientesEnFechaDeterminada(Date date) {
        return ventasEnDeterminadaFecha(date).stream().mapToDouble(v -> v.dineroAhorradoPorCliente()).sum();
    }

    @Override
    public int calcularCantidadDeVentas() {
        return ventas.size();
    }

    @Override
    public Double calcularDineroMovido() {
        return ventas.stream().mapToDouble(v -> v.getMontoVenta()).sum();
    }

    @Override
    boolean todasSusVentasFueronConDescuento() {
        return ventas.stream().allMatch(v -> v.todosLosProductosSeVendieronConDescuento());
    }


}

