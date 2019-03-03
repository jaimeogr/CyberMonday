public abstract class Establecimiento {

    private String lugar;

    abstract int calcularCantidadDeVentas();
    abstract Double calcularDineroMovido();
    abstract boolean todasSusVentasFueronConDescuento ();



    public Establecimiento (String lugar){
        this.lugar = lugar;
    }

    public String getLugar() {
        return lugar;
    }

}
