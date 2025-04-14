create table devices
(
    id serial primary key,
    name_devices  varchar(255),
    price float
);

create table people
(
    id serial primary key,
    name_people varchar(255)
);

create table devices_people
(
    id serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices (name_devices, price) values ('phone t1', 4000.00);
insert into devices (name_devices, price) values ('phone z91', 8900.00);
insert into devices (name_devices, price) values ('phone t4', 3500.00);
insert into devices (name_devices, price) values ('phone z90', 8000.00);
insert into devices (name_devices, price) values ('tablet n1', 4200.00);
insert into devices (name_devices, price) values ('tablet n11', 6300.00);
insert into devices (name_devices, price) values ('tablet r3', 7700.00);

insert into people (name_people) values ('Max');
insert into people (name_people) values ('Alex');
insert into people (name_people) values ('Ivan');
insert into people (name_people) values ('Steve');

insert into devices_people (device_id, people_id) values (1,1);
insert into devices_people (device_id, people_id) values (2,1);
insert into devices_people (device_id, people_id) values (1,2);
insert into devices_people (device_id, people_id) values (3,3);
insert into devices_people (device_id, people_id) values (3,4);
insert into devices_people (device_id, people_id) values (4,1);
insert into devices_people (device_id, people_id) values (5,2);
insert into devices_people (device_id, people_id) values (6,4);

select avg(d.price) from devices as d;
select * from devices;

select p.name_people, avg(d.price)
from devices_people as dp
join people as p on p.id = dp.people_id
join devices as d on d.id = dp.device_id
group by p.name_people;

select p.name_people, avg(d.price)
from devices_people as dp
join people as p on p.id = dp.people_id
join devices as d on d.id = dp.device_id
group by p.name_people
having avg(d.price) > 5000;