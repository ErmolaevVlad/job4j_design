create table car_bodies
(
    id serial primary key,
    name_car_bodies varchar(255)
);

create table car_engines
(
    id serial primary key,
    name_car_engines varchar(255)
);

create table car_transmissions
(
    id serial primary key,
    name_car_transmissions varchar(255)
);

create table cars
(
    id serial primary key,
    name_car varchar(255),
    body_id int references car_bodies(id),
    engine_id int references car_engines(id),
    transmission_id int references car_transmissions(id)
);

insert into car_bodies (id, name_car_bodies) values (1, 'седан');
insert into car_bodies (id, name_car_bodies) values (2, 'хэтчбек');
insert into car_bodies (id, name_car_bodies) values (3, 'пикап');
insert into car_bodies (id, name_car_bodies) values (4, 'джип');
insert into car_bodies (id, name_car_bodies) values (5, 'универсал');

insert into car_engines (id, name_car_engines) values (1, 'бензиновый');
insert into car_engines (id, name_car_engines) values (2, 'дизельный');
insert into car_engines (id, name_car_engines) values (3, 'электрический');

insert into car_transmissions (id, name_car_transmissions) values (1, 'автомат');
insert into car_transmissions (id, name_car_transmissions) values (2, 'механика');
insert into car_transmissions (id, name_car_transmissions) values (3, 'робот');
insert into car_transmissions (id, name_car_transmissions) values (4, 'вариатор');

insert into cars (id, name_car, body_id, engine_id, transmission_id) values (1, 'toyota', 1, 1, 1);
insert into cars (id, name_car, body_id, engine_id, transmission_id) values (2, 'nissan', 4, 1, 4);
insert into cars (id, name_car, body_id, engine_id, transmission_id) values (3, 'volvo', 1, 1, 2);
insert into cars (id, name_car, body_id, engine_id, transmission_id) values (4, 'mazda', 2, 2, 1);

select * from car_bodies cb
    left join cars on cb.id = cars.body_id
    where cars.id is null;

select * from car_engines ce
    left join cars on ce.id = cars.engine_id
    where cars.id is null;

select * from car_transmissions ct
    left join cars on ct.id = cars.transmission_id
    where cars.id is null;