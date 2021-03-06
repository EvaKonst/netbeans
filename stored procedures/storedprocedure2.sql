ALTER PROCEDURE [dbo].[EmployeePayment]
(
	@emp_name VARCHAR(25),
	@emp_lname VARCHAR(25),
	@emp_salary INT OUTPUT
)



AS
BEGIN
	DECLARE @emp_hiredate DATE;
	DECLARE @cur_date DATE;
	DECLARE @w_exp INT;
	DECLARE @p_work INT;
	DECLARE @jour_email VARCHAR (50);
	DECLARE @x INT;
	DECLARE @count INT;

	IF (SELECT journalist_email from journalist inner join employee on journalist_email=employee_email where @emp_name=employee_name AND @emp_lname=employee_lastname) IS NULL 
		begin 
			SELECT 'Please give another journalist name' ;
		end
	ELSE 
		begin 
			SET @jour_email = (SELECT journalist_email from journalist inner join employee on journalist_email=employee_email where @emp_name=employee_name AND @emp_lname=employee_lastname)
			SET @emp_hiredate = (SELECT employee_hiredate from employee where @emp_name=employee_name AND @emp_lname=employee_lastname)
			SET @cur_date = (SELECT GETDATE())
			SET @p_work = (SELECT work_exp_months from journalist where @jour_email=journalist_email)
			SET @w_exp = (SELECT DATEDIFF(month, @emp_hiredate , @cur_date)) + @p_work
			SET @x = 650
			SET @count = 1
			WHILE @count <= @w_exp 
			BEGIN 
				SET @emp_salary = @x + 650*5/1000
				SET @x = @emp_salary 
				SET @count = @count + 1
			END 
				SELECT @emp_salary  AS 'The salary';
		END

END
