import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeUpdaterSingleton {
	public static EmployeeUpdaterSingleton instance;
	static final String DB_URL = "jdbc:mysql://localhost:3306/swd_company_db";
	static final String USER = "root";
	static final String PASS = "root";
	
	private EmployeeUpdaterSingleton() {
		
	}
	
	public static EmployeeUpdaterSingleton getInstance() {
		if (instance == null) {
			instance = new EmployeeUpdaterSingleton();
		}
		
		return instance;
	}
	
	// Note that you cannot update the emp_id, because it's the primary key
	// All update methods follow update generic
	private static void updateGeneric(Employee employee, String newCell, String column) {
		// Get the emp_id, because it's unique
		int employeeID = employee.getEmployeeID();
		String updateStatement = "UPDATE Employees SET " + column + " = \""
				+ newCell + "\" WHERE emp_id = " + employeeID + ";";
		
		// PreparedStatement is different from Statement because it prevents
		// SQL injection.
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement pstmt = conn.prepareStatement(updateStatement);) {
			pstmt.executeUpdate();
			// Make sure to add System.out.println in relevant update methods.
			System.out.print("Successfully updated employeeID " + employeeID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateFirstName(Employee employee, String newFirstName) {
		String oldName = employee.getFirstName();
		updateGeneric(employee, newFirstName, "first_name");
		System.out.println("\'s first name from " + oldName + " to " + newFirstName);
	}
	
	public void updateLastName(Employee employee, String newLastName) {
		String oldName = employee.getLastName();
		updateGeneric(employee, newLastName, "last_name");
		System.out.println("\'s last name from " + oldName + " to " + newLastName);
	}
	
	// Using the SSNValidator Singleton
	public void updateSSN(Employee employee, String newSSN) {
		SSNValidator validator = SSNValidatorSingleton.getInstance();
		if (!validator.validate(newSSN)) {
			System.out.println("SSN is not valid.");
			return;
		}
		
		String oldSSN = employee.getSsn();
		updateGeneric(employee, newSSN, "ssn");
		System.out.println("\'s ssn from " + oldSSN + " to " + newSSN);
	}
	
	public void updateJobTitle(Employee employee, String newJobTitle) {
		String oldJobTitle = employee.getJobTitle();
		updateGeneric(employee, newJobTitle, "last_name");
		System.out.println("\'s last name from " + oldJobTitle + " to " + newJobTitle);
	}
	
	public void updateDivision(Employee employee, String newJobTitle) {
		String oldJobTitle = employee.getJobTitle();
		updateGeneric(employee, newJobTitle, "last_name");
		System.out.println("\'s last name from " + oldJobTitle + " to " + newJobTitle);
	}
}
