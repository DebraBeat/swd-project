import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SSNStrategy implements SearchStrategy {
	static final String DB_URL = "jdbc:mysql://localhost:3306/swd_company_db";
	static final String USER = "root";
	static final String PASS = "root";
	
	public SSNStrategy() {
	}
	
	@Override
	public Employee search(String ssn, String tableName) {
		Employee employee = null;
		
		String query = "SELECT * FROM " + tableName + " WHERE ssn = \"" + 
		ssn + "\";";
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next()) {
	        	  // Retrieve by column names
	        	  int employeeID = rs.getInt("emp_id");
	        	  String employeeFirstName = rs.getString("first_name");
	        	  String employeeLastName = rs.getString("last_name");
	        	  // ssn is of type String intentionally
	        	  String employeeSSN = rs.getString("ssn");
	        	  String jobTitle = rs.getString("job_title");
	        	  String division = rs.getString("Division");
	        	  double salary = rs.getDouble("salary");
	        	  // hireDate is of type String intentionally
	        	  String hireDate = rs.getString("hire_date");
	        	  
	        	  employee = new Employee.EmployeeBuilder(
	        			  employeeID, employeeFirstName, employeeLastName, employeeSSN, jobTitle,
	        			  division, salary, hireDate).build();
	        	  employee.asString();
	          }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
	}
}
