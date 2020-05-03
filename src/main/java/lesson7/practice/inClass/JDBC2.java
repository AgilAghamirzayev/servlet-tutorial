package lesson7.practice.inClass;

import java.sql.*;

public class JDBC2 {

    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String NAME = "postgres";
    private final static String PASSWORD = "1999Aqil";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, NAME, PASSWORD);
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = " insert into users (age, name) VALUES (?,?)";
        try {
            ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, 12);
            ps.setString(2, "Azad");

            int i = ps.executeUpdate();//success olanda 1 ,  error olanda -1 qaytarir
            if (i > 0) {
                rs = ps.getGeneratedKeys();// en son daxil edilen setrin primaryKey'ni yeni id'ni qaytarir
                if (rs.next()) {
                    long id = rs.getLong("id");
                    System.out.println(id);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("exception");
        } finally {
            assert rs != null;
            rs.close();
            ps.close();
        }
    }
}
