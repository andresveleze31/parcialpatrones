package org.example.implementacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListaReproduccionDAO {
    private final String url = "jdbc:postgresql://dpg-csr7not2ng1s73f3lbu0-a:5432/andresvelezdb";
    private final String user = "andresvelezdb_user";
    private final String password = "CbOfv1O1A98406hbkl8xtAVkSUKHczYl";

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void guardarLista(ListaReproduccion lista) {
        String sql = "INSERT INTO listas_reproduccion (nombre_lista, cancion_ids, contador_uso) VALUES (?, ?, ?) "
                + "ON CONFLICT(nombre_lista) DO NOTHING";
        try (Connection conn = conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, lista.getNombreLista());
            pstmt.setString(2, obtenerIdsCanciones(lista));
            pstmt.setInt(3, lista.getContadorUso());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String obtenerIdsCanciones(ListaReproduccion lista) {
        StringBuilder ids = new StringBuilder();
        for (Cancion cancion : lista.getCanciones()) {
            ids.append(cancion.getId()).append(",");
        }
        return ids.length() > 0 ? ids.substring(0, ids.length() - 1) : "";
    }

    public List<ListaReproduccion> obtenerListasMenosUsadas() {
        List<ListaReproduccion> listas = new ArrayList<>();
        String sql = "SELECT * FROM listas_reproduccion ORDER BY contador_uso ASC LIMIT 10";
        try (Connection conn = conectar(); Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String nombre = rs.getString("nombre_lista");
                String idsCanciones = rs.getString("cancion_ids");
                ListaReproduccion lista = new ListaReproduccion(nombre);
                for (String id : idsCanciones.split(",")) {
                    lista.addCancionPorId(Long.parseLong(id));
                }
                listas.add(lista);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listas;
    }
}
