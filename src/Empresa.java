import java.util.*;
import java.util.stream.Collectors;

public class Empresa  { //TODO: que funcion tiene el "<K, V>" en esta linea? yo al final puse Integer en el momento en el que declase el map
    ArrayList<Establecimiento> establecimientos = new ArrayList<Establecimiento>();
    ArrayList<String> lugaresAAnalizar = new ArrayList<String>();


    public int calcularCantidadVentasDeEstablecimiento(Establecimiento establecimiento){
        return establecimientos.stream().filter(e -> e == establecimiento).mapToInt(e -> e.calcularCantidadDeVentas()).sum();
    }

    public Double calcularDineroMovidoPorEstablecimiento (Establecimiento establecimiento){
        return establecimientos.stream().filter(e -> e == establecimiento).mapToDouble(e -> e.calcularDineroMovido()).sum();
    }

    public String calcularLugarAAnalizarConMasVentas(){
        Map<String, Integer> map = new HashMap<>(); //TODO: de estqa forma no uso la funcion hashcode(), esta bien? me parece mas simple e igualmente util
        establecimientos.stream().filter(e -> lugaresAAnalizar.contains(e.getLugar())).forEach(e -> map.put(e.getLugar(), map.get(e.getLugar()) + e.calcularCantidadDeVentas())); // TODO: esta bien la suma usando el get y para conseguir el valor en la key especificada? o si retorna null entonces puede fallar?
        Integer maxValue = 0;
        Map.Entry<String, Integer> maxEntry = null; //TODO: esta forma de obtener la key relaconada al valor maximo es eficiente? hay alguna forma mejor?
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();

        //ESTO DE ABAJO FUE PARA HACER PRUEBAS Y AL FINAL ENCONTRE UNA FORMA MEJOR
//        for(Integer value : map.values().stream().collect(Collectors.toList())){ //TODO: como podria haber hecho una mejor forma de conseguir el valor maximo de este map
//            if(value > maxValue)
//                maxValue = value;
//        }
//        //TODO: hay alguna forma mejor para obtener la key relacionada al valor maximo del map?
    }

    public boolean lugarTieneSoloVentasConDescuentos (String lugar){
        return establecimientos.stream().filter(e -> e.getLugar().equals(lugar)).allMatch(e -> e.todasSusVentasFueronConDescuento());
    }
}
