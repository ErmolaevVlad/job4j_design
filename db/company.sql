select p.name, c.name
from person as p
join company as c on c.id = p.company_id
where c.id != 5;


select c.name, count(*)
from company as c, person as p
where c.id = p.company_id
group by c.name
having count(*) = (select count(person.*)
                    from person
                    group by person.company_id
                    order by 1 desc limit 1);
