import java.util.ConcurrentModificationException;

public class Electronica implements Producto {

    private static final double CONSTANT = 15;
    private static Double factorDeConversion = 2.5;
    private Double descuento;

    private Double constanteAlMomentoDeVenta;
    private Double factorDeConversionAlMomentoDeVenta;


    public Electronica ( Double descuento){
        this.descuento = descuento;
    }

    public static void setFactorDeConversion(Double factorDeConversion) {
        Electronica.factorDeConversion = factorDeConversion;
    }

    @Override
    public Double calcularCostoConDescuento() {
        return calcularCosto() * descuento;
    }

    public void setDatosAlMomentoDeVenta (){
        constanteAlMomentoDeVenta = CONSTANT;
        factorDeConversionAlMomentoDeVenta = factorDeConversion;
    }

    public boolean estaEnDescuento (){
        if(descuento > 0)
            return true;
        else
            return false;
    }


    @Override
    public double calcularDineroAhorradoPorCliente() {
        return calcularCostoConDescuento() - calcularCosto();
    }


    public Double getDescuento (){
        return this.descuento;
    }

    @Override
    public Double calcularCosto() {
        return factorDeConversion* CONSTANT;
    }


}
