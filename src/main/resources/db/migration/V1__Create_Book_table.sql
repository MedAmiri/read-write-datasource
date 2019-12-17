-- Create Books table.
CREATE TABLE books (
  id INTEGER NOT NULL,
  author VARCHAR(254) NOT NULL,
  title VARCHAR(254) NOT NULL,
  CONSTRAINT pk_id PRIMARY KEY (id)
);

-- Create a sequence for Hibernate.
CREATE SEQUENCE hibernate_sequence START 1;