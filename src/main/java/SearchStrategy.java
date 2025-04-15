import java.util.List;

public interface SearchStrategy {
	// For searching the Employees database
	public List<Employee> employeeSearch(String input);

	// For searching the Payments database 
	public List<Payment> paymentSearch(String input);
}
