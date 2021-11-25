ALTER TABLE journalist DROP COLUMN work_exp;
ALTER TABLE journalist ADD work_exp_months INT;

UPDATE journalist SET work_exp_months = 5 WHERE journalist_email='fountou@upatras.gr';

UPDATE journalist SET work_exp_months = 7 WHERE journalist_email='peppa@upatras.gr';
