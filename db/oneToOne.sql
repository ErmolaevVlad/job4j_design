create table capital (
    id serial primary key,
    name varchar(255)
);

create table country(
    id serial primary key,
    name varchar(255),
    capital_id int references capital(id) unique
);

insert into capital (name) values ('London');
insert into country (name, capital_id) values ('UK', 1);