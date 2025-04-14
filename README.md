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

* Facade pattern uses:
	* Change employee table; add column SSN (no dashes).

	* Update employee data:
		* SSN verification should be private method

## Builder Pattern
### EmployeeBuilder
This class provides a way to create an instance of the ```Employee``` class using the builder design pattern.
The advantage of the builder pattern is that some attributes of the class can be empty, and although not implemented in our program, we can set defaults if needed.

Reference: https://www.digitalocean.com/community/tutorials/builder-design-pattern-in-java

### PaymentBuilder

## Strategy Pattern

## Singleton Pattern
### SSN Validation:
This module provides a clean and reusable way to validate Social Security Numbers (SSNs) using Java. It’s built around two key ideas: an interface that defines the rules for validation, and a singleton class that does the actual work.

The validator checks if an SSN is either:

- A 9-digit number with no separators (like `123456789`), or
An 11-character string in the format `123-45-6789`, with dashes in the right places.
Anything else gets flagged as invalid—like misplaced dashes or non-numeric characters. The singleton pattern ensures we’re not creating multiple instances of the validator all over the place, which keeps things efficient and easy to manage.

- If you're looking to plug in validation somewhere or just want to see how interfaces and singletons work together in Java, this is a good, lightweight example. Check out the SSNValidatorTest class to see how to use it.

## Facade Pattern