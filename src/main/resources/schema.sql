-- For h2, use schema.sql initialize the database
-- and data.sql to populate it with data.
-- table names become CAPITAL in h2!
CREATE TABLE bigsmall (
                          id INTEGER PRIMARY KEY AUTO_INCREMENT,
                          answer INTEGER,
                          name VARCHAR
);