import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NameStrategy implements SearchStrategy {
	static final String DB_URL = "jdbc:mysql://localhost:3306/swd_company_db";
	static final String USER = "root";
	static final String PASS = "root";
	
	public NameStrategy() {
	}
	
	@Override
	public Employee search(String input, String tableName) {
		Employee employee = null;
		String[] fullName = input.trim().split(" ");
		
		String firstName = fullName[0];
		String lastName = fullName[1];
		String query = "SELECT * FROM " + tableName + " WHERE first_name = \"" + 
		firstName + "\" AND last_name = \"" + lastName + "\";";
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next()) {
	        	  // Retrieve by column names
	        	  int employeeID = rs.getInt("emp_id");
	        	  String employeeFirstName = rs.getString("first_name");
	        	  String employeeLastName = rs.getString("last_name");
	        	  // ssn is of type String intentionally
	        	  String ssn = rs.getString("ssn");
	        	  String jobTitle = rs.getString("job_title");
	        	  String division = rs.getString("Division");
	        	  double salary = rs.getDouble("salary");
	        	  // hireDate is of type String intentionally
	        	  String hireDate = rs.getString("hire_date");
	        	  
	        	  employee = new Employee.EmployeeBuilder(
	        			  employeeID, employeeFirstName, employeeLastName, ssn, jobTitle,
	        			  division, salary, hireDate).build();
	        	  employee.asString();
	          }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
	}
}
