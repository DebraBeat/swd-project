public class StrategyTest {

	public static void main(String[] args) {
		Employee employee = null;
		NameStrategy nameTester = new NameStrategy();
		SSNStrategy ssnTester = new SSNStrategy();
		
		employee = nameTester.search("John Doe", "Employees");
		System.out.println(employee.asString());
		
		employee = ssnTester.search("111223344", "Employees");
		System.out.println(employee.asString());
	}

}
