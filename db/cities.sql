create table city (
	id serial primary key,
	name varchar(255),
	country text,
	population integer
);
insert into city (name, country, population) values ('Москва', 'Россия', '13000');
select * from city;
update city set population = '13500000';
select * from city;
delete from city;
select * from city;
