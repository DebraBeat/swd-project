import java.util.List;
import java.util.ArrayList;

public class StrategyTest {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		NameStrategy nameTester = new NameStrategy();
		SSNStrategy ssnTester = new SSNStrategy();
		
		employeeList = nameTester.employeeSearch("John Doe");
		for (Employee employee : employeeList) {
			System.out.println(employee.asString());
		}
		
		employeeList = ssnTester.employeeSearch("111223344");
		for (Employee employee : employeeList) {
			System.out.println(employee.asString());
		}
	}

}
