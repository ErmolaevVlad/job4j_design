create table departments
(
    id serial primary key,
    name_department varchar(255)
);

create table employees (
    id serial primary key,
    name_employees varchar(255),
    department_id int references departments(id)
);

create table teens (
    id serial primary key,
    name_teens varchar(255),
    gender varchar(255)
)

insert into departments (id, name_department) values (1, 'Первый');
insert into departments (id, name_department) values (2, 'Второй')
insert into departments (id, name_department) values (3, 'Третий');

insert into employees (id, name_employees, department_id) values (1, 'Иван', 1);
insert into employees (id, name_employees, department_id) values (2, 'Павел', 1);
insert into employees (id, name_employees, department_id) values (3, 'Александр', 1);
insert into employees (id, name_employees, department_id) values (4, 'Анна', 2);
insert into employees (id, name_employees, department_id) values (5, 'Владимир', 2);
insert into employees (id, name_employees, department_id) values (6, 'Наталья', null );
insert into employees (id, name_employees, department_id) values (7, 'Игорь', null );

insert into teens (id, name_teens, gender) values (1, 'Иван', 'М');
insert into teens (id, name_teens, gender) values (2, 'Павел', 'М');
insert into teens (id, name_teens, gender) values (3, 'Наталья', 'Ж');
insert into teens (id, name_teens, gender) values (4, 'Юля', 'Ж');
insert into teens (id, name_teens, gender) values (5, 'Игорь', 'М');
insert into teens (id, name_teens, gender) values (6, 'Анна', 'Ж');

select  * from employees e
    left join departments d on d.id = e.department_id;

select * from departments d
    right join employees e on d.id = e.department_id;

select * from employees e
    right join departments d on d.id = e.department_id;

select * from employees e
    full join departments d on d.id = e.department_id;

select * from employees e
    cross join departments d;

select  * from departments d
    left join employees e on d.id = e.department_id
    where e.department_id is null;

select * from departments d
    left join employees e on d.id = e.department_id;
select * from employees e
    right join departments d on d.id = e.department_id
 order by d.id;

select *from teens t1
    cross join teens t2
    where (t1.gender LIKE '%М%' and t2.gender LIKE '%Ж%');