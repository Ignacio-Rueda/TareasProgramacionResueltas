package ejercicios;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ejercicio06 {

    public static void main(String[] args) {
        List<Producto> listaProductos = new ArrayList<>();

        listaProductos.add(new Producto("sardinas", LocalDate.of(2023, 12, 31), 1.50));
        listaProductos.add(new Producto("caballa", LocalDate.of(2023, 12, 25), 1.70));
        listaProductos.add(new Producto("navajas", LocalDate.of(2021, 01, 01), 2.40));
        listaProductos.add(new Producto("mejillones", LocalDate.of(2022, 01, 11), 2.10));
        System.out.println("ORDENACIÓN DE PRODUCTOS");
        System.out.println("-----------------------");
        System.out.println("Contenido inicial de la lista:");
        for (int n = 0; n < listaProductos.size(); n++) {
            System.out.printf("%d. %s%n", n + 1, listaProductos.get(n));
        }
        System.out.println("\nOrdenación de la lista por nombre de producto");
        Collections.sort(listaProductos, new ComparadorProductosPorNombre());
        for (int n = 0; n < listaProductos.size(); n++) {
            System.out.printf("%d. %s%n", n + 1, listaProductos.get(n));
        }
        System.out.println("\nOrdenación de la lista por caducidad de producto");
        Collections.sort(listaProductos, new ComparadorProductosPorCaducidad());
        for (int n = 0; n < listaProductos.size(); n++) {
            System.out.printf("%d. %s%n", n + 1, listaProductos.get(n));
        }
        System.out.println("\nOrdenación de la lista por precio de producto");
        Collections.sort(listaProductos, new ComparadorProductosPorPrecioDesc());
        for (int n = 0; n < listaProductos.size(); n++) {
            System.out.printf("%d. %s%n", n + 1, listaProductos.get(n));
        }

    }
}

class ComparadorProductosPorNombre implements Comparator<Producto> {

    @Override
    public int compare(Producto p1, Producto p2) {
        return p1.getNombre().compareTo(p2.getNombre());
    }

}

class ComparadorProductosPorCaducidad implements Comparator <Producto>{

    @Override
    public int compare(Producto p1, Producto p2) {
        return p1.getCaducidad().compareTo(p2.getCaducidad());
    }

}

class ComparadorProductosPorPrecioDesc implements Comparator <Producto> {

    @Override
    public int compare(Producto p1, Producto p2) {
        return Double.compare(-p1.getPrecio(), -p2.getPrecio());
    }

        
}
