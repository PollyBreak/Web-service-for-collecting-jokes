<<<<<<< HEAD
create database funny_db;
use funny_db;

create table category_jokes(
    category_id int PRIMARY KEY AUTO_INCREMENT,
    name text
);

create table jokes(
id int PRIMARY KEY AUTO_INCREMENT,
category int,
text text,
rating int default 0,
foreign key (category) references category_jokes(category_id));

create table memes(
id int PRIMARY KEY AUTO_INCREMENT,
url text,
rating int default 0);

create table new_memes(
id int PRIMARY KEY AUTO_INCREMENT,
url text,
decision bool);

create table new_jokes(
id int PRIMARY KEY AUTO_INCREMENT,
category int,
text text,
decision bool,
foreign key (category) references category_jokes(category_id));
=======
>>>>>>> main
