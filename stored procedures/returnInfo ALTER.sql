USE [dlab1]
GO
/****** Object:  StoredProcedure [dbo].[returnInfoPage]    Script Date: 26-Mar-20 9:36:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER PROCEDURE [dbo].[returnInfoPage]
(
	@page_num INT,
	@news_name VARCHAR(255) OUTPUT,
	@page_count INT OUTPUT,
	@date_publ DATE OUTPUT,
	@page_sales INT OUTPUT,
	@return_num INT OUTPUT
)
AS
	SET @news_name = (SELECT newspaper_name FROM page WHERE page_number = @page_num)
	SET @page_count = (SELECT page_count FROM page WHERE page_number = @page_num)
	SET @date_publ = (SELECT date_published FROM page WHERE page_number = @page_num)
	SET @page_sales = (SELECT sales FROM page WHERE page_number = @page_num)
	SET @return_num = (SELECT returned FROM page WHERE page_number = @page_num)
