begin transaction;
declare cursor_p scroll cursor for select * from products;
fetch last from cursor_p;
move backward 4 from cursor_p;
fetch prior from cursor_p;
move backward 7 from cursor_p;
fetch prior from cursor_p;
move backward 4 from cursor_p;
fetch prior from cursor_p;
fetch prior from cursor_p;
close cursor_p;
commit;