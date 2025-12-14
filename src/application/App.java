package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;

public class App {
    public static void main(String[] args) throws Exception {
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new DB().getConnection();
            
            ps = conn.prepareStatement("SELECT * FROM DEPARTMENT");
            
            rs = ps.executeQuery();
            while(rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("ID")
                    + ", Name: " + rs.getString("NAME")
                );
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeResultSet(rs);
            DB.closePreparedStatement(ps);
            DB.closeConnection();
        }
    }
}
