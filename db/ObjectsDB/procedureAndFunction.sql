create
or replace procedure delete_data(u_count integer)
language 'plpgsql'
as $$
	BEGIN
		delete from products where count < u_count;
	END;
$$;

call delete_data(10);

create
or replace function f_delete_data()
returns integer
language 'plpgsql'
as
$$
	declare
		result integer;
	begin
		select into result count(*)
		from products
		where count = 0;
		delete from products where count = 0;
		return result;
	end;
$$;

select f_delete_data();