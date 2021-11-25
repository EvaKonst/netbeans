

CREATE PROCEDURE newCat
(
	@catname VARCHAR(255),
	@catdesc VARCHAR(255),
	@chief_email VARCHAR(50),
	@parentname VARCHAR(255)
)	
	AS
		DECLARE @parent_id INT 
		SET @parent_id =( SELECT parent_id FROM category  WHERE @parentname =cat_name)
				
		INSERT INTO category(category_id,cat_name,cat_desc,chief_editor_email,parent_id)VALUES((SELECT ISNULL(MAX(category_id)+1,0) FROM category WITH(SERIALIZABLE, UPDLOCK)),@catname,@catdesc,@chief_email,@parent_id)
	GO