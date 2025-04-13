Thinking about this with design patterns:
1. Builder pattern uses:
 a. Creation of Employee instance

2. Strategy pattern uses:
 a. Reports:
   - Full-time employee information with pay statement history. 
   - Total pay for month by job title.
   - Total pay for month by Division. 

 b. Searching:
   - By SSN
   - By Name
   - By emp_id

3. Facade pattern uses:
 a. Change employee table; add column SSN (no dashes).

 b. Update employee data:
   - SSN verification should be private method


# SSN Validation:
This module provides a clean and reusable way to validate Social Security Numbers (SSNs) using Java. It’s built around two key ideas: an interface that defines the rules for validation, and a singleton class that does the actual work.

The validator checks if an SSN is either:

- A 9-digit number with no separators (like `123456789`), or
An 11-character string in the format `123-45-6789`, with dashes in the right places.
Anything else gets flagged as invalid—like misplaced dashes or non-numeric characters. The singleton pattern ensures we’re not creating multiple instances of the validator all over the place, which keeps things efficient and easy to manage.

- If you're looking to plug in validation somewhere or just want to see how interfaces and singletons work together in Java, this is a good, lightweight example. Check out the SSNValidatorTest class to see how to use it.