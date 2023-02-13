insert into db_for_fun.roles (role) values ('USER'), ('ADMIN');

insert into db_for_fun.users (username, first_name, email, password) values ('PollyBreak', 'Polina', 'polly@mail.ru',
 '{bcrypt}$2y$10$OEj39LHJek6/DHHSExSwFeq4jjiEALpVgBnswZobiXEXDIGjuJsWa');
 
commit;