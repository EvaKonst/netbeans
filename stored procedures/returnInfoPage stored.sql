CREATE PROCEDURE returnInfoPage
(
	@page_num INT,
	@news_name VARCHAR(255) OUTPUT,
	@page_count INT OUTPUT,
	@date_publ DATE OUTPUT,
	@page_sales INT OUTPUT
)
AS
	SET @news_name = (SELECT newspaper_name FROM page WHERE page_number = @page_num)
	SET @page_count = (SELECT page_count FROM page WHERE page_number = @page_num)
	SET @date_publ = (SELECT date_published FROM page WHERE page_number = @page_num)
	SET @page_sales = (SELECT sales FROM page WHERE page_number = @page_num)
GO	