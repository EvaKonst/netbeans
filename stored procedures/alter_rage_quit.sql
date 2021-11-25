CREATE TABLE publisher(publisher_email VARCHAR(50),PRIMARY KEY(publisher_email),FOREIGN KEY(publisher_email) REFERENCES employee(employee_email));
ALTER TABLE newspaper DROP CONSTRAINT DF__newspaper__owner__66603565;
ALTER TABLE newspaper DROP COLUMN owner_name;
ALTER TABLE newspaper ADD owner_email VARCHAR(50) FOREIGN KEY(owner_email) REFERENCES publisher(publisher_email);
