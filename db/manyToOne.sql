create table car (
	id serial primary key,
	name varchar(255)
);

create table owner_car (
	id serial primary key,
	name varchar(255),
	car_id int references car(id)
);

insert into car (name) values ('car 1');
insert into owner_car (name, car_id) values ('Ivan', 1);

select * from owner_car;
select * from car where id in (select car_id from owner_car);