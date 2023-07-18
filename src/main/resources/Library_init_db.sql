CREATE DATABASE `library_db` DEFAULT CHARACTER SET utf8mb3;

CREATE TABLE `literary_formats`
(
    `format`     varchar(255)     DEFAULT NULL,
    `id`         bigint  NOT NULL AUTO_INCREMENT,
    `is_deleted` tinyint NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8mb3;

CREATE TABLE `books`
(
    `id`                 bigint  NOT NULL AUTO_INCREMENT,
    `tittle`             varchar(255)     DEFAULT NULL,
    `price`              decimal(10, 0)   DEFAULT NULL,
    `is_deleted`         tinyint NOT NULL DEFAULT '0',
    `literary_format_id` bigint           DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `books_literary_formats_fk` (`literary_format_id`),
    CONSTRAINT `books_literary_formats_fk` FOREIGN KEY (`literary_format_id`) REFERENCES `literary_formats` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb3;

CREATE TABLE `library_db`.`authors`
(
    `id`       bigint NOT NULL AUTO_INCREMENT,
    `name`     varchar(255) DEFAULT NULL,
    `lastName` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

SELECT *
FROM authors;

CREATE TABLE `library_db`.`books_authors`
(
    `book_id`   bigint NOT NULL,
    `author_id` bigint NOT NULL,
    CONSTRAINT `books_authors_books_fk` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`),
    CONSTRAINT `books_authors_authors_fk` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`)
);
SELECT *
FROM books_authors;

SELECT b.id  as book_id,
       tittle,
       price,
       lf.id as literary_format_id,
       format
FROM books b
         JOIN literary_formats lf on b.literary_format_id = lf.id
WHERE b.id = 1;

SELECT *
FROM literary_formats
WHERE id = 2;

UPDATE literary_formats
SET is_deleted = false
WHERE id = 2;

UPDATE books
SET is_deleted = TRUE
WHERE tittle = 'Tom&Jerry';

INSERT INTO authors (name, lastName)
VALUES ('Taras', 'Shevchenko');

INSERT INTO authors (name, lastName)
VALUES ('Olena', 'Ivanova');

INSERT INTO authors (name, lastName)
VALUES ('Bogdan', 'Chupika');

INSERT INTO books_authors (`book_id`, `author_id`)
VALUES (1, 1);
INSERT INTO books_authors (`book_id`, `author_id`)
VALUES (2, 2);
INSERT INTO books_authors (`book_id`, `author_id`)
VALUES (2, 3);
SELECT * FROM books;
SELECT * FROM authors;
SELECT * FROM books_authors;



