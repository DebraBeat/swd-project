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