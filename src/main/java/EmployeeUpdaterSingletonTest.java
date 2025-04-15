import java.util.ArrayList;
import java.util.List;

public class EmployeeUpdaterSingletonTest {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		NameStrategy nameTester = new NameStrategy();
		EmployeeUpdaterSingleton employeeUpdater = EmployeeUpdaterSingleton.getInstance();
		
		String newName = "Mike";
		
		employeeList = nameTester.employeeSearch("Michael Brown");
		System.out.println(employeeList.get(0).asString());
		
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateFirstName(employee, newName);
		}
		
		employeeList = nameTester.employeeSearch("Mike Brown");
		System.out.println(employeeList.get(0).asString());
		
		if (employeeList.size() > 0) {
			Employee employee = employeeList.get(0);
			employeeUpdater.updateFirstName(employee, "Michael");
		}
		
		employeeList = nameTester.employeeSearch("Michael Brown");
		System.out.println(employeeList.get(0).asString());
	}

}
