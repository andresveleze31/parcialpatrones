package org.example.implementacion;

public class Cancion {
    private Long id;
    private String nombreCancion;
    private byte[] cancionData = new byte[1000000]; // Simulación de datos de canción.

    public Cancion(Long id, String nombreCancion) {
        this.id = id;
        this.nombreCancion = nombreCancion;
    }

    public Cancion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    @Override
    public String toString() {
        return "Cancion{" + "id=" + id + ", nombre=" + nombreCancion + '}';
    }
}

