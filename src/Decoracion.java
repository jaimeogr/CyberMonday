import java.util.LinkedList;

public class Decoracion implements Producto {


    private Double peso;
    private Double ancho;
    private Double alto;
    private LinkedList<Material> materiales = new LinkedList<Material>();
    private Double descuento;

    public Decoracion(Double peso, Double ancho, Double alto, LinkedList<Material> materiales, Double descuento) {
        this.peso = peso;
        this.alto = alto;
        this.ancho = ancho;
        this.materiales = materiales;
        this.descuento = descuento;
    }

    @Override
    public Double calcularCostoConDescuento() {
        return calcularCosto()*descuento;
    }

    public void añadirMaterial (Material material){
        materiales.add(material);
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
        Double costo = new Double(0);
        costo += peso * ancho * alto;
        costo += materiales.stream().mapToDouble(m -> m.getValor()).sum();
        return costo;
    }

    @Override
    public double calcularDineroAhorradoPorCliente() {
        return calcularCostoConDescuento() - calcularCosto();
    }
}
