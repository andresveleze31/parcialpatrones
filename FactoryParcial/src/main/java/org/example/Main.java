package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://dpg-csr7not2ng1s73f3lbu0-a:5432/andresvelezdb";
        String user = "andresvelezdb_user";
        String password = "CbOfv1O1A98406hbkl8xtAVkSUKHczYl";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
