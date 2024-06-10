

update users set status_id = 2 where id = 27;
-------------------12
select * from package_price;
select * from subject_has_price_package;
select * from subjects;

select p.id, p.name, p.duration,p.original_price
from package_price p
where p.id in(
select price_package_id from  subject_has_price_package 
where subject_id = 2);


select * from Subject_Register;
insert into Subject_Register 
values(2,27,1,null,null,null,'pending');


select * from users;
insert into users(full_name, email, phone_number, password,gender,created_at,role_id,status_id) 
values('yentyen', 'yen@gmail.com','12312','123',1,'2024-06-06',1,2);


SELECT SCOPE_IDENTITY() AS LastInsertedId;
SELECT @@IDENTITY AS LastInsertedId;