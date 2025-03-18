create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna (name, avg_age, discovery_date) values ('Myodes glareolus', 420, '1780-5-23');
insert into fauna (name, avg_age, discovery_date) values ('Australian crows', 7300, '1850-2-20');
insert into fauna (name, avg_age, discovery_date) values ('Wolf', 5840, '1753-8-21');
insert into fauna (name, avg_age, discovery_date) values ('Agamai', 5475, '1853-9-14');
insert into fauna (name, avg_age, discovery_date) values ('Wapiti', 6935, '1777-4-18');
insert into fauna (name, avg_age, discovery_date) values ('Balloon fish', 3285, '1798-8-11');
insert into fauna (name, avg_age, discovery_date) values ('Cacatua sanguinea', 18250, '1840-4-27');
insert into fauna (name, avg_age, discovery_date) values ('Giant tortoise', 36500, null);

select * from fauna where name like '%fish%';
select * from fauna where avg_age >= 10000 AND avg_age <=20000;
select * from fauna where discovery_date is Null;
select * from fauna where discovery_date < '1950.01.01';
