import java.util.List;
import java.util.ArrayList;

public interface SearchStrategy {
	public List<Employee> employeeSearch(String input);
	public List<Payment> paymentSearch(String input);
}
