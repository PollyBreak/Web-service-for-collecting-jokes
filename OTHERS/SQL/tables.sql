create database db_for_fun;
use db_for_fun;

create table category_jokes(
    category_id int PRIMARY KEY AUTO_INCREMENT,
    name text NOT NULL
);

create table jokes(
id int PRIMARY KEY AUTO_INCREMENT,
text text NOT NULL,
category_id int,
foreign key (category_id) references category_jokes(category_id));

create table memes(
id int PRIMARY KEY AUTO_INCREMENT,
url text);

create table db_for_fun.users(
user_id int PRIMARY KEY AUTO_INCREMENT,
username varchar(15) UNIQUE NOT NULL,
first_name varchar(15) NOT NULL,
email varchar(30) UNIQUE NOT NULL,
password varchar(300) NOT NULL,
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
);

/*
create table new_memes(
id int PRIMARY KEY AUTO_INCREMENT,
url text,
decision bool);
*/

create table new_jokes(
id int PRIMARY KEY AUTO_INCREMENT,
text text NOT NULL,
category_id int,
author_id int,
foreign key (category_id) references category_jokes(category_id),
foreign key (author_id) references users(user_id)); 


