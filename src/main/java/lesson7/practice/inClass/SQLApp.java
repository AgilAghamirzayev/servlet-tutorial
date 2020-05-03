package lesson7.practice.inClass;

import java.sql.*;

public class SQLApp {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String NAME = "postgres";
    private static final String PSW = "1999Aqil";

    public static void main(String[] args) throws SQLException {
        Connection conn  = DriverManager.getConnection(URL,NAME, PSW);

        String username = "Aqil";
        int age = 21;

        String loginSql = "SELECT * FROM users WHERE name = ? and age = ?";
        PreparedStatement statement = conn.prepareStatement(loginSql);
        statement.setString(1,username);
        statement.setInt(2,age);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.printf("%d : %d : %s\n",
                    resultSet.getInt("id"),
                    resultSet.getInt("age"),
                    resultSet.getString("name"));
        }
    }

}
