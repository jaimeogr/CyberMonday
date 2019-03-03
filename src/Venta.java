import java.util.Date;
import java.util.LinkedList;

public class Venta {
    private LinkedList<ItemVenta> itemsVenta = new LinkedList<ItemVenta>();
    private Date date;
    public Venta (Date date){
        this.date = date;
    }

    public Double getMontoVenta(){
        return itemsVenta.stream().mapToDouble(iv -> iv.getSubCosto()).sum();
    }

    public void agregarItemVenta (ItemVenta iv){
        itemsVenta.add(iv);
    }

    public boolean alMenosUnProductoEnPromocion(){
         return itemsVenta.stream().anyMatch(iv -> iv.productoEnPromocionAlMomentoDeVenta());
    }

    public Date getDate() {
        return date;
    }

    public Double dineroAhorradoPorCliente (){
        return itemsVenta.stream().mapToDouble(iv -> iv.dineroAhorradoPorCliente()).sum();
    }

    public boolean todosLosProductosSeVendieronConDescuento (){
        return itemsVenta.stream().allMatch(iv -> iv.productoEnPromocionAlMomentoDeVenta());
    }
}
