public class Employee {
	private String firstName;
	private String lastName;
	
	// Matching VARCHAR(9) in Employees table
	private String ssn;
	
	private String jobTitle;
	private String division;
	private double salary;
	
	// Make sure this is formatted as DateTime
	private String hireDate;

	public Employee(Employee.EmployeeBuilder employeeBuilder) {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public String getDivision() {
		return division;
	}

	public double getSalary() {
		return salary;
	}

	public String getHireDate() {
		return hireDate;
	}
	
	public static class EmployeeBuilder {
		private String firstName;
		private String lastName;
		
		// Matching VARCHAR(9) in Employees table
		private String ssn;
		
		private String jobTitle;
		private String division;
		private double salary;
		
		// Make sure this is formatted as DateTime
		private String hireDate;

		public EmployeeBuilder(String firstName, String lastName, String ssn, String jobTitle, String division,
				double salary, String hireDate) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.ssn = ssn;
			this.jobTitle = jobTitle;
			this.division = division;
			this.salary = salary;
			this.hireDate = hireDate;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public void setSsn(String ssn) {
			SSNValidator validator = SSNValidatorSingleton.getInstance();
			
			if (validator.validate(ssn)) {
				this.ssn = ssn;
			} else {
				System.out.println("Re-enter SSN");
			}
			
		}

		public void setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
		}

		public void setDivision(String division) {
			this.division = division;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public void setHireDate(String hireDate) {
			// TODO: Implement validator
			this.hireDate = hireDate;
		}
		
		public Employee build() {
			return new Employee(this);
		}
	}
}
