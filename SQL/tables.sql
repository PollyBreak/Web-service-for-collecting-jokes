сreate database funny_db;

create table jokes(
id int PRIMARY KEY AUTO_INCREMENT,
category_id int,
text text,
rating int default 0);

create table memes(
id int PRIMARY KEY AUTO_INCREMENT,
url text,
rating int default 0);

create table new_jokes(
id int PRIMARY KEY AUTO_INCREMENT,
url text,
decision char(30));

create table category_jokes(
    id int PRIMARY KEY AUTO_INCREMENT,
    name text
);



