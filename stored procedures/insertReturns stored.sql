CREATE PROCEDURE insertReturns
(
	@page_num INT,
	@return_num INT
)
AS
	UPDATE page SET returned = @return_num WHERE page_number = @page_num;
GO