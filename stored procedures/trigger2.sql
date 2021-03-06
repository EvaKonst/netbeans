ALTER TRIGGER [dbo].[articles_editor]
	 ON [dbo].[article]
	 INSTEAD OF INSERT 
AS 
BEGIN
		DECLARE @edit_email VARCHAR (50);
		SET @edit_email=(SELECT editor_email from inserted article)
		IF (SELECT chief_editor_email from chief_editor where chief_editor_email=@edit_email) is null 
		BEGIN
			INSERT INTO article SELECT article_path, title, pages, status, summary, key_word, chief_editor_email, category_id, page_number, approve_date, page_start, editor_email from inserted article;
		END 
		ELSE 
		BEGIN
		INSERT INTO article SELECT article_path, title, pages, status, summary, key_word, chief_editor_email, category_id, page_number, approve_date, page_start, editor_email from inserted article;
		UPDATE article SET status = 'accepted'  WHERE @edit_email=editor_email;
		END
END
