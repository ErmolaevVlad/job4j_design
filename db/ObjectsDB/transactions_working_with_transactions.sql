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
VALUES ('material_6', 'producer_6', 6, 140);

begin transaction;
insert into materials(name_materials, producer, count, price)
    values('material_7', 'producer_7', 14, 98);

savepoint first_transaction;
select * from materials;

insert into materials(name_materials, producer, count, price)
    values('material_8', 'producer_8', 16, 918);

update materials set price = 165 where name_materials = 'material_4';

select * from materials;

rollback to first_savepoint;
select * from materials;

commit transaction;