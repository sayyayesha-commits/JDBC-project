import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/internship_day1";
        String user = "postgres";
        String password = "Aisha@2005";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to PostgreSQL successfully!");

            String query = "SELECT * FROM departments";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("department_id") + " - " +
                                rs.getString("department_name")
                );
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}

