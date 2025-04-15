# Outline of Database Schema
* Employee Table
	* emp_id INT AUTO_INCREMENT PRIMARY KEY,
	* first_name VARCHAR(100),
	* last_name VARCHAR(100),
	* ssn VARCHAR(9),  -- No dashes, only numbers
	* job_title VARCHAR(100),
	* division VARCHAR(100),
	* salary DECIMAL(10, 2),
	* hire_date DATE
* Payments Table
	* payment_id INT auto_increment primary KEY,
	* emp_id int,
	* payment_date date,
	* amount int,
	* foreign key (emp_id) references Employees(emp_id)

# Outline of Project with design patterns
* Builder pattern uses:
	* Creation of Employee instance
	* Creation of Payment instance

* Strategy pattern uses:
	* Reports:
		* Full-time employee information with pay statement history. 
		* Total pay for month by job title.
		* Total pay for month by Division. 

	* Searching:
		* By SSN
		* By Name
		* By emp_id
		
* Singleton pattern uses:
	* SSN Validation Pattern

	* Date Validation Pattern

	* Update
		* Generically update employee data
		* Update employee's salary for an increase of a particular percentage only for a salary amount range. E.G., 3.2% for salary greater than, equal to 58K but less than 105K. 

* Facade pattern uses:
	* Change employee table; add column SSN (no dashes).

	* Update employee data:
		* SSN verification should be private method

## Builder Pattern
Reference: https://www.digitalocean.com/community/tutorials/builder-design-pattern-in-java

### EmployeeBuilder
This class provides a way to create an instance of the `Employee` class using the builder design pattern.
The advantage of the builder pattern is that some attributes of the class can be empty, and although not implemented in our program, we can set defaults if needed.

### PaymentBuilder
Similar to how `Employee` is implemented, this class provides a way to create an instance of the `Payment` class using the builder design pattern.

## Strategy Pattern
Reference: https://www.digitalocean.com/community/tutorials/strategy-design-pattern-in-java-example-tutorial

### NameStrategy
Implements `SearchStrategy` to search through the `Employees` table and `Payments` table by employee name.
### SSNStrategy
Implements `SearchStrategy` to search through the `Employees` table and `Payments` table by employee SSN.
### EmployeeIDStrategy
Implements `SearchStrategy` to search through the `Employees` table and `Payments` table by employee ID.

## Singleton Pattern
Reference: https://refactoring.guru/design-patterns/singleton/java/example

### Update Employee

### SSN Validation:
This module provides a clean and reusable way to validate Social Security Numbers (SSNs) using Java. It’s built around two key ideas: an interface that defines the rules for validation, and a singleton class that does the actual work.

The validator checks if an SSN is either:

- A 9-digit number with no separators (like `123456789`), or
An 11-character string in the format `123-45-6789`, with dashes in the right places.
Anything else gets flagged as invalid—like misplaced dashes or non-numeric characters. The singleton pattern ensures we’re not creating multiple instances of the validator all over the place, which keeps things efficient and easy to manage.

- If you're looking to plug in validation somewhere or just want to see how interfaces and singletons work together in Java, this is a good, lightweight example. Check out the SSNValidatorTest class to see how to use it.

## Facade Pattern