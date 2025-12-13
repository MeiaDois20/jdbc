package application;

import java.sql.Connection;

import model.entities.DB;

public class App {
    public static void main(String[] args) throws Exception {
        Connection conn = new DB().getConnection();
        System.out.println("Conexão aberta!");
        conn.close();
    }
}
