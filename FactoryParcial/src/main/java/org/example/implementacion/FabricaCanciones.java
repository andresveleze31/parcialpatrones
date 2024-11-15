package org.example.implementacion;

import java.util.HashMap;
import java.util.Map;

public class FabricaCanciones {
    public static boolean habilitarFlyweight = true;
    private static final Map<String, Cancion> playCancion = new HashMap<>();
    private static Long secuencia = 0L;

    public static Cancion crearItem(String nombreTema) {
        if (habilitarFlyweight && playCancion.containsKey(nombreTema)) {
            return playCancion.get(nombreTema);
        } else {
            Cancion cancion = new Cancion(++secuencia, nombreTema);
            playCancion.put(nombreTema, cancion);
            return cancion;
        }
    }
}