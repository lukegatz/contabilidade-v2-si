DROP TABLE IF EXISTS tbl_post;

CREATE TABLE IF NOT EXISTS tbl_post (
	id INT  NOT NULL PRIMARY KEY, 
	autor VARCHAR(150) NOT NULL, 
	titulo VARCHAR(150) NOT NULL,
	texto VARCHAR(MAX) NOT NULL,
	data TIMESTAMP NOT NULL
);

create sequence hibernate_sequence start with 1 increment by 1;

