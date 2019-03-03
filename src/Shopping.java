import java.util.ArrayList;

public class Shopping extends Establecimiento {



    private ArrayList<Local> locales = new ArrayList<Local>();

    public Shopping(String lugar) {
        super(lugar);
    }

    @Override
    public int calcularCantidadDeVentas() {
        return locales.stream().mapToInt(l -> l.calcularCantidadDeVentas()).sum();
    }

    @Override
    public Double calcularDineroMovido() {
        return locales.stream().mapToDouble(l -> l.calcularDineroMovido()).sum();
    }

    @Override
    boolean todasSusVentasFueronConDescuento() {
        return locales.stream().allMatch(local -> local.todasSusVentasFueronConDescuento());
    }
}
