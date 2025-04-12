import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnectExample {
   static final String DB_URL = "jdbc:mysql://localhost:3306/swd_company_db";
   static final String USER = "root";
   static final String PASS = "root";
   static final String QUERY = "SELECT * FROM Employees";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
//          Extract data from result set
          while (rs.next()) {
             // Retrieve by column name
//             System.out.print("ID: " + rs.getInt("id"));
//             System.out.print(", Age: " + rs.getInt("age"));
             System.out.print("First name: " + rs.getString("first_name"));
             System.out.print(", Lastname : " + rs.getString("last_name"));
             System.out.println(", Employee_ID: " + rs.getInt("emp_id"));
          }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}