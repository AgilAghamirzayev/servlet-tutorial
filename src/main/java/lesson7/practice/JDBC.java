package lesson7.practice;

import java.sql.*;
import java.util.Scanner;

public class JDBC {

    private final static Scanner scanner = new Scanner(System.in);
    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String NAME = "postgres";
    private final static String PSW = "1999Aqil";

    public static void main(String[] args) {

        String name = scanner.nextLine();
        String password = scanner.nextLine();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet r_set = null;


        try {
            String insert = "insert into student(username, password) values (?,?)";
            conn = DriverManager.getConnection(URL, NAME, PSW);
            st = conn.prepareStatement(insert);
            st.setString(1, name);
            st.setString(2, password);
            r_set = st.executeQuery();

            while (r_set.next()) {
                String username = r_set.getString("username");
                String password_ = r_set.getString("password");
                System.out.printf("%s: %s\n", username, password_);
            }

        } catch (SQLException e) {
            System.out.print(e.getMessage());
        } finally {
            try {
                assert conn != null;
                conn.close();
                assert st != null;
                st.close();
                assert r_set != null;
                r_set.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}

