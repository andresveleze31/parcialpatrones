package org.example.implementacion;

import java.util.ArrayList;
import java.util.List;

public class ListaReproduccion {
    private String nombreLista;
    private List<Cancion> canciones = new ArrayList<>();
    private int contadorUso;

    public ListaReproduccion(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public int getContadorUso() {
        return contadorUso;
    }

    public void incrementarUso() {
        this.contadorUso++;
    }

    public void addCancion(String nombreCancion) {
        canciones.add(FabricaCanciones.crearItem(nombreCancion));
    }

    public void addCancionPorId(Long id) {
        // Aquí se debe recuperar la canción de la fábrica utilizando el ID.
        // Este ejemplo asume que tienes una manera de obtener la canción por su ID.
        Cancion cancion = FabricaCanciones.crearItem("Song " + id); // Ajusta según tu lógica de recuperación.
        canciones.add(cancion);
    }

    @Override
    public String toString() {
        return "ListaReproduccion{" + "nombre=" + nombreLista + ", uso=" + contadorUso + '}';
    }
}
