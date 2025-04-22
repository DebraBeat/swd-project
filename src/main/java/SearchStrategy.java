import java.util.List;

public interface SearchStrategy {
	static final String DB_URL = "jdbc:mysql://localhost:3306/swd_company_db";
	static final String USER = "root";
	static final String PASS = "root";
	
	// For searching the Employees database
	public List<Employee> employeeSearch(String input);

	// For searching the Payments database 
	public List<Payment> paymentSearch(String input);
}
