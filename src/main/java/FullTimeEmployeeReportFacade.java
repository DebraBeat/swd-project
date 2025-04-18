import java.util.List;
import java.util.ArrayList;

/**
 * This class represents an easy way to generate an employee report with a
 * simple method call
 * 
 * @author Debra Ritter
 */
public class FullTimeEmployeeReportFacade {
	/**
	 * Get all employees by searching for every Employee ID.
	 * Since EIDs are unique we'll get a list of all employees.
	 */
	public void generateReport() {
		List<Employee> employeeList = new ArrayList<>();
		EmployeeIDStrategy employeeIDSearch = new EmployeeIDStrategy();
		employeeList = employeeIDSearch.employeeSearch("*");
		
		System.out.println("*".repeat(30));
		
		for (Employee e : employeeList) {
			System.out.println("Payment history for " + e.getFirstName() + " " + e.getLastName());
		}
	}
}
