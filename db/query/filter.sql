create table type
(
    id serial primary key,
    name_type varchar(255)
)

create table product
(
    id serial primary key,
    name_product varchar(255),
    type_id int references type(id),
    expired_date timestamp,
    price float
);

insert into type (id, name_type) values (1, 'СЫР');
insert into type (id, name_type) values (2, 'МОЛОКО');
insert into type (id, name_type) values (3, 'МОРОЖЕНОЕ');

insert into product (id, name_product, type_id, expired_date, price) values (1, 'Сыр плавленный', 1, '2025-04-20', 500);
insert into product (id, name_product, type_id, expired_date, price) values (2, 'Сыр твердый', 1, '2025-04-21', 400);
insert into product (id, name_product, type_id, expired_date, price) values (3, 'Сыр моцарелла', 1, '2025-04-12', 600);

insert into product (id, name_product, type_id, expired_date, price) values (4, 'Молоко домашнее', 2, '2025-04-12', 100);
insert into product (id, name_product, type_id, expired_date, price) values (5, 'Молоко кактус', 2, '2025-04-14', 110);
insert into product (id, name_product, type_id, expired_date, price) values (6, 'Молоко импорт', 2, '2025-04-09', 120);

insert into product (id, name_product, type_id, expired_date, price) values (7, 'Мороженое в стаканчике', 3, '2025-04-21', 150);
insert into product (id, name_product, type_id, expired_date, price) values (8, 'Мороженое пломбир', 3, '2025-04-26', 190);
insert into product (id, name_product, type_id, expired_date, price) values (9, 'Мороженое брикет', 3, '2025-04-23', 200);
insert into product (id, name_product, type_id, expired_date, price) values (10, 'Мороженое стандарт', 3, '2025-04-23', 300);
insert into product (id, name_product, type_id, expired_date, price) values (11, 'Мороженое gold', 3, '2025-04-23', 600);


select * from product where product.type_id = 1;

select * from product where name_product LIKE '%Мороженое%';

select * from product where expired_date < '2025-04-13';

select * from product
where price = (select max(price) from product);

select type.name_type, count(*) from type
join product on type.id = product.type_id
group by type.name_type;

select * from product
where product.type_id = 1 or product.type_id = 2;

select name_type from type
join product on type.id = product.type_id
group by type.name_type
having count(*) < 4;

select type.name_type, product.* from type
join product on type.id = product.type_id;


