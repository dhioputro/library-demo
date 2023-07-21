CREATE TABLE IF NOT EXISTS book(
    book_id VARCHAR(250),
    title VARCHAR(250) ,
    author VARCHAR(250),
    publisher VARCHAR(250),
    launch_date VARCHAR(250),
    pages VARCHAR(250),
    status NUMERIC,
    borrower VARCHAR(250),
    borrow_date VARCHAR(250),
    return_date VARCHAR(250)
);