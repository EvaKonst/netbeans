ALTER PROCEDURE [dbo].[ShowElemOfArticles]
@news_name VARCHAR (50),
@p_number INT


AS

BEGIN

	DECLARE @page_c INT; /*ο αριθμός των σελίδων του φύλλου*/
	DECLARE @max_start INT; /*η σελίδα από την οποία ξεκινάει το τελευταίο άρθρο του φύλλου*/
	DECLARE @pages_max INT; /*η εκταση του τελευταίου άρθρου σε σελίδες*/
	DECLARE @white_pages INT; /*οι κενές σελίδες μετά το πέρας του τελευταίου αρθρου*/
	SET @max_start=(SELECT MAX(page_start) FROM article INNER JOIN employee ON editor_email=employee_email where @p_number=page_number);
	SET @pages_max= (SELECT pages  FROM article where @p_number=page_number AND page_start= @max_start);
	SET @page_c = (SELECT page_count FROM page WHERE @p_number=page_number);
	IF @max_start IS NULL 
		BEGIN 
			SET @white_pages = @page_c;
			SELECT @white_pages AS 'THE PAGES LEFT';
		END 
	ELSE
		BEGIN 
			SET @white_pages = @page_c - @pages_max - @max_start;
		IF (SELECT page_number FROM page WHERE @news_name= newspaper_name AND @p_number=page_number) IS NOT NULL 
			BEGIN
				SELECT title, pages, employee_name, employee_lastname, approve_date, page_start FROM article INNER JOIN employee ON editor_email=employee_email where @p_number=page_number ORDER BY page_start ASC; 
				SELECT @white_pages AS 'THE PAGES LEFT';
			END 
		ELSE 
			BEGIN 
				SELECT 'PLEASE SELECT ANOTHER PAGE OR ANOTHER NEWSPAPER'
		END
	END
END