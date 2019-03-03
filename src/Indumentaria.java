public class Indumentaria implements Producto {
    private double descuento;
    private Integer talle;
    private Double factorDeConversion;

    public  Indumentaria (Integer talle, Double factorDeConversion, double descuento){
        this.talle = talle;
        this.factorDeConversion = factorDeConversion;
        this.descuento = descuento;
    }

    @Override
    public Double calcularCostoConDescuento() {
        return calcularCosto()*descuento;
    }

    public boolean estaEnDescuento (){
        if(descuento > 0)
            return true;
        else
            return false;
    }

    public Double getDescuento (){
        return this.descuento;
    }

    @Override
    public Double calcularCosto() {
        return talle*factorDeConversion;
    }

    @Override
    public double calcularDineroAhorradoPorCliente() {
        return calcularCostoConDescuento() - calcularCosto();
    }
}
