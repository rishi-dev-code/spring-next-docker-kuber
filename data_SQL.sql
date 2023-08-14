--to get all custom tables by user 
SELECT * FROM pg_tables t where tableowner=current_user ;

CREATE SEQUENCE bm_id_seq
INCREMENT 1
START 1;


DROP TABLE  bookmarks;

CREATE TABLE bookmarks (
book_id int ,
book_title VARCHAR NOT NULL,
book_url VARCHAR,
created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
PRIMARY KEY (book_id)  
);

INSERT INTO  bookmarks (book_id,book_title,book_url) 
VALUES(nextval('bm_id_seq'),'Batman 10','www.google.com/batman');  

INSERT INTO  bookmarks (book_id,book_title,book_url) 
VALUES(nextval('bm_id_seq'),'Superman 6','www.google.com/superman'); 

select * from bookmarks;
select * from flyway_schema_history;