create table materials
(
    id       serial primary key,
    name_materials     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);
insert into materials (name_materials, producer, count, price)
VALUES ('material_1', 'producer_1', 3, 70);
insert into materials (name_materials, producer, count, price)
VALUES ('material_2', 'producer_2', 15, 90);
insert into materials (name_materials, producer, count, price)
VALUES ('material_3', 'producer_3', 8, 120);
insert into materials (name_materials, producer, count, price)
VALUES ('material_4', 'producer_4', 17, 65);
insert into materials (name_materials, producer, count, price)
VALUES ('material_5', 'producer_5', 13, 45);
insert into materials (name_materials, producer, count, price)
VALUES ('material_6', 'producer_6', 6, 140);