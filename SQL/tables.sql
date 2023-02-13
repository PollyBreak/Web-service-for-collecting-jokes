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

<<<<<<< Updated upstream:SQL/tables.sql
=======
create table db_for_fun.users(
user_id int PRIMARY KEY AUTO_INCREMENT,
username varchar(15) UNIQUE NOT NULL,
first_name varchar(15) NOT NULL,
email varchar(30) UNIQUE NOT NULL,
password varchar(30) NOT NULL,
status BOOL default 1 NOT NULL
);

create table db_for_fun.roles(
role_id int PRIMARY KEY AUTO_INCREMENT,
role varchar(20) UNIQUE NOT NULL
);

create table db_for_fun.user_roles(
user_id int,
role_id int,
foreign key (user_id) references db_for_fun.users(user_id),
foreign key (role_id) references db_for_fun.roles(role_id)
)

/*
>>>>>>> Stashed changes:OTHERS/SQL/tables.sql
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
