create table people (
    id serial primary key,
    people_name varchar(255)
);

create table personal_data (
    id serial primary key,
    people_id int references people(id),
    age int
);

insert into people (people_name) values ('Alex');
insert into people (people_name) values ('Max');
insert into people (people_name) values ('Steve');

insert into personal_data (people_id, age) values (1, 28);
insert into personal_data (people_id, age) values (2, 45);
insert into personal_data (people_id, age) values (3, 19);
insert into personal_data (age) values (59);

select * from personal_data join people on personal_data.people_id = people.id;
select * from personal_data as pd join people as p on pd.people_id = p.id;
select p.people_name, pd.age from people p join personal_data pd on p.id= pd .people_id;
select p.people_name Имя, pd.age Возраст from people p join personal_data pd on p.id= pd .people_id;