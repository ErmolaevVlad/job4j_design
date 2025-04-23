create table students
(
    id   serial primary key,
    name_students varchar(50)
);

insert into students (name_students)
values ('Иван Иванов');
insert into students (name_students)
values ('Петр Петров');
insert into students (name_students)
values ('Владимир Сидоров');

create table authors
(
    id   serial primary key,
    name_authors varchar(50)
);

insert into authors (name_authors)
values ('Александр Пушкин');
insert into authors (name_authors)
values ('Николай Гоголь');
insert into authors (name_authors)
values ('Федор Достоевский');

create table books
(
    id serial primary key,
    name_book varchar(200),
    author_id integer references authors (id)
);

insert into books (name_book, author_id)
values ('Евгений Онегин', 1);
insert into books (name_book, author_id)
values ('Капитанская дочка', 1);
insert into books (name_book, author_id)
values ('Дубровский', 1);
insert into books (name_book, author_id)
values ('Мертвые души', 2);
insert into books (name_book, author_id)
values ('Вий', 2);
insert into books (name_book, author_id)
values ('Преступление и наказание', 3);
insert into books (name_book, author_id)
values ('Братья Карамазавы', 3);
insert into books (name_book, author_id)
values ('Белые ночи', 3);

create table orders
(
    id serial primary key,
    active boolean default true,
    book_id integer references books (id),
    student_id integer references students (id)
);

insert into orders (book_id, student_id)
    values (1, 1);
insert into orders (book_id, student_id)
    values (3, 1);
insert into orders (book_id, student_id)
    values (5, 2);
insert into orders (book_id, student_id)
    values (4, 1);
insert into orders (book_id, student_id)
    values (2, 2);
insert into orders (book_id, student_id)
    values (7, 3);
insert into orders (book_id, student_id)
    values (8, 3);
insert into orders (book_id, student_id)
    values (9, 3);

insert into orders (book_id, student_id, active)
    values (5, 1, false );
insert into orders (book_id, student_id, active)
    values (2, 1, false );
insert into orders (book_id, student_id, active)
    values (1, 2, false );
insert into orders (book_id, student_id, active)
    values (3, 2, false );
insert into orders (book_id, student_id, active)
    values (4, 2, false );

select s.name_students, a.name_authors, count(b.name_book) from students as s
    join orders o on s.id = o.student_id
    join books b on o.book_id = b.id
    join authors a on b.author_id = a.id
    where o.active = false
    group by (s.name_students, a.name_authors)
    having count(b.name_book) >= 2;

create view show_students_with_false_order_2_or_more_books_same_author
as
select s.name_students, a.name_authors, count(b.name_book) from students as s
    join orders o on s.id = o.student_id
    join books b on o.book_id = b.id
    join authors a on b.author_id = a.id
    where o.active = false
    group by (s.name_students, a.name_authors)
    having count(b.name_book) >= 2;

select * from show_students_with_false_order_2_or_more_books_same_author;
