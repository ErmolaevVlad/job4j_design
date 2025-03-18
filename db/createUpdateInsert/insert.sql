insert into roles (name) values ('Manager');
insert into roles (name) values ('Administrator');
insert into roles (name) values ('master');

insert into users (name, roles_id) values ('Alex', 1);
insert into users (name, roles_id) values ('Max', 2);
insert into users (name, roles_id) values ('Steve', 3);

insert into rules (name) values ('all');
insert into rules (name) values ('sales');
insert into rules (name) values ('service center');

insert into categories (name) values ('equipment repair');
insert into categories (name) values ('purchase');
insert into categories (name) values ('mixed');

insert into states (name) values ('closed');
insert into states (name) values ('work');
insert into states (name) values ('registered');


insert into items (name, users_id, categories_id, states_id) values ('Item 1', 3, 1, 3);
insert into items (name, users_id, categories_id, states_id) values ('Item 2', 2, 3, 1);

insert into attachs (name, items_id) values ('file1.txt', 2);

insert into comments (comment, items_id) values ('comment', 1);





