package lesson6.jcdb;

import java.sql.*;

public class SqlApp {
    private final static String URL = "jdbc:postgresql://localhost:5432/test";
    private final static String NAME = "postgres";
    private final static String PSW = "1999Aqil";

    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection(URL, NAME, PSW);
        String SQL = "SELECT * FROM person where email<>'null'";
        PreparedStatement stmt = conn.prepareStatement(SQL);
        ResultSet r_set = stmt.executeQuery();


        System.out.printf("%4s|%15s  | %17s | %7s  | %15s        | %30s           | %20s           \n",
                "id", "first_name", "last_name", "gender", "date", "email", "country_of_birth");
        System.out.println(
                "----+-----------------+-------------------+----------+------------------------+------------------------------------------+----------------------------");


        while (r_set.next()) {
            int id = r_set.getInt("id");
            String first_name = r_set.getString("first_name");
            String last_name = r_set.getString("last_name");
            String gender = r_set.getString("gender");
            Date date_of_birth = r_set.getDate("date_of_birth");
            String email = r_set.getString("email");
            String country_of_birth = r_set.getString("country_of_birth");

            System.out.printf("%04d| %15s | %17s | %7s  | %17s      | %35s      |  %25s      \n", id, first_name,
                    last_name,
                    gender,
                    date_of_birth, email, country_of_birth);
        }

        stmt.close();
        r_set.close();
    }
}
