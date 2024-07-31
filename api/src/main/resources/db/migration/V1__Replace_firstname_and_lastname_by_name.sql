-- V1__Replace_firstname_and_lastname_by_name.sql

ALTER TABLE users
ADD COLUMN name VARCHAR(255);

UPDATE users
SET name = COALESCE(firstName, '') || ' ' || COALESCE(lastName, '');

ALTER TABLE users
DROP COLUMN firstName,
DROP COLUMN lastName;
