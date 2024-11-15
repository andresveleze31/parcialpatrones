package org.example.implementacion;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlyweightMain {

    private static final String[] nombresCanciones = new String[1000];
    private static final List<ListaReproduccion> listas = new ArrayList<>();

    public static void main(String[] args) {
        ListaReproduccionDAO dao = new ListaReproduccionDAO();
        List<ListaReproduccion> listasMenosUsadas = dao.obtenerListasMenosUsadas();

        for (ListaReproduccion lista : listasMenosUsadas) {
            listas.add(lista);
        }

        // Lógica adicional para crear listas y usar Flyweight
        inicializarArreglos();
        crearListaDinamica();
        System.out.println("Total Listas > " + listas.size());
    }

    private static void inicializarArreglos() {
        for (int c = 0; c < nombresCanciones.length; c++) {
            nombresCanciones[c] = "Song " + (c + 1);
        }
    }

    private static void crearListaDinamica() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            ListaReproduccion lista = new ListaReproduccion("Lista " + i);
            for (int j = 0; j < 10; j++) {
                lista.addCancion(nombresCanciones[random.nextInt(nombresCanciones.length)]);
            }
            listas.add(lista);
        }
    }
}
