create
or replace function tax_new()
	returns trigger as
$$
	BEGIN
		update products
		set price = price + price * 0.2
		where id = (select id from inserted);
		return new;
	END;
$$
LANGUAGE 'plpgsql';

create trigger tax_new_trigger
	after insert
	on products
	referencing new table as
					inserted
	for each statement
	execute procedure tax_new();

create
or replace function tax_new_before()
	returns trigger as
$$
	BEGIN
		new.price = new.price + new.price * 0.3;
		return new;
	END;
$$
LANGUAGE 'plpgsql';

create trigger tax_new_before_trigger
	before insert
	on products
	for each row
	execute procedure tax_new_before();

create
or replace function price_product()
	returns trigger as
$$
	BEGIN
		insert into history_of_price (name, price, date)
		values(new.name, new.price, current_date);
		return new;
	END;
$$
LANGUAGE 'plpgsql';

create trigger price_product_trigger
	after insert on products
	for each row
	execute procedure price_product();