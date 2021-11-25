CREATE TRIGGER salary_emp
    ON employee 
	INSTEAD OF INSERT 
  
AS 
BEGIN
		declare @emp_email VARCHAR(50);
		SET @emp_email=(SELECT employee_email from inserted employee)
		INSERT INTO  employee SELECT employee_email , employee_name, employee_lastname, employee_hiredate, employee_salary, newspaper_name, employee_login, employee_pass from inserted employee;
		UPDATE employee SET employee_salary = '650' WHERE @emp_email = employee_email;
END
GO