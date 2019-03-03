public class ItemVenta {
    private Producto producto;
    private Integer cantidad;

    public ItemVenta(Producto producto, Integer cantidad) {
        this.cantidad = cantidad;
        this.producto = producto;
        if (producto instanceof Electronica) {
            ((Electronica) producto).setDatosAlMomentoDeVenta();
        }
    }

    public Double getSubCosto() {
        return producto.calcularCostoConDescuento() * cantidad;
    }

    public boolean productoEnPromocionAlMomentoDeVenta() {
        return producto.estaEnDescuento();
    }

    public double dineroAhorradoPorCliente() {
        return producto.calcularDineroAhorradoPorCliente()*cantidad;
    }
}
