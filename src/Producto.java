public interface Producto {
    public Double calcularCostoConDescuento();

    public boolean estaEnDescuento ();

    public Double getDescuento ();

    public Double calcularCosto();

    double calcularDineroAhorradoPorCliente();
    //TODO: Decorator? wrapper? como se usa para el descuento/promociones? sirve para tener mas de una promocion?

    // si yo quisiera usar decorator, como
}
