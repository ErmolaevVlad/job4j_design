CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

insert into customers
values (1, 'Иванов', 'Иван', 30, 'Russia'),
(2, 'Петров', 'Александр', 27, 'Russia'),
(3, 'Смит', 'Джон', 34, 'Англия'),
(4, 'Доусон', 'Алекс', 37, 'Канада'),
(5, 'Смирнов', 'Сергей', 28, 'Казахстан'),
(6, 'Висконти', 'Адриано', 25, 'Италия');

insert into orders
values (1, 3, 1),
(2, 4, 3),
(3, 1, 4),
(4, 2, 6);

select * from customers c
 where c.id NOT IN (select orders.customer_id from orders);