SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS book; 
DROP TABLE IF EXISTS category; 
DROP TABLE IF EXISTS app_user;

SET FOREIGN_KEY_CHECKS=1;


CREATE TABLE category (
categoryid BIGINT NOT NULL AUTO_INCREMENT, 
name VARCHAR(50) NOT NULL,
PRIMARY KEY (categoryid)
);


INSERT INTO category (name) 
VALUES ('Kaunokirjat'),
('Tietokirjat'),
('Lasten kirjat');



CREATE TABLE book
(id BIGINT NOT NULL AUTO_INCREMENT,
title VARCHAR(100) NOT NULL,
author VARCHAR(100) NOT NULL,
isbn VARCHAR(50) NOT NULL,
publication_year INT NOT NULL,
price DOUBLE NOT NULL,
categoryid BIGINT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (categoryid) REFERENCES category(categoryid)
);


INSERT INTO book ( 
title, author, isbn, publication_year, price, categoryid)
VALUES 
('Huonetoveri', 'Ruth Ware', '9789511450337', 2023, 27.95, 1),
('Sota vai rauha', 'Mihail Shishkin', '9789510491850', 2023, 33.95, 2),
('Pipsa ja unen lähtölaskenta', 'Virve Lehväs', '9789511393924', 2021, 14.95, 3),
('Neulottu Kalevala', 'Jenna Kostet', '9789527468418', 2022, 34.95, 2);



CREATE TABLE app_user
(id BIGINT NOT NULL AUTO_INCREMENT,
username VARCHAR(100) NOT NULL,
password VARCHAR(100) NOT NULL,
email  VARCHAR(100) NOT NULL,
role VARCHAR(250) NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO app_user (username, password, email, role) 
VALUES ('user', '$2a$10$mR2WmGjLXN3t6v.cjNWY8upoHecRvcGjmq7slGq.9wwY83BD3yJkK', 'user@mail.com', 'USER'), 
('admin', '$2a$10$jzx/BIs9sqsRfAaJOeGWeuqFbH/GG4Uxuz82ysgG5gn0ygew53GuW', 'admin@mail.com', 'ADMIN');


SELECT * FROM category;
SELECT * FROM book;
SELECT * FROM app_user;