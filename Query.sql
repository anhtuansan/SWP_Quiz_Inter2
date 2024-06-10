

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


--------------------Menu - Role(1-user, 2-admin, 3-sale, 4-marketing, 5-expert)
------------------------------13
--------------------Subject register : Status(pending/done)
select * from Subject_Register;
select * from users;

select r.id,s.name, r.CreatedAt, p.name, p.original_price, r.Status 
from Subject_Register r 
left join subjects s on r.SubjectId = s.id
left join package_price p on p.id = r.PackageId
WHERE r.UserId = 27


WITH PagedResults AS (
    SELECT r.id,s.name AS subject_name, r.CreatedAt, p.name AS package_name, p.original_price, r.Status,
           ROW_NUMBER() OVER (ORDER BY r.CreatedAt) AS row_num
    FROM Subject_Register r 
    LEFT JOIN subjects s ON r.SubjectId = s.id
    LEFT JOIN package_price p ON p.id = r.PackageId
    WHERE r.UserId = 27
)
SELECT * 
FROM PagedResults
WHERE row_num BETWEEN 1 AND 5
ORDER BY row_num;


select * from subjects;
insert into Subject_Register 
values(6,27,1,GETDATE(),null,null,'pending');
insert into Subject_Register 
values(7,27,1,GETDATE(),null,null,'pending');
insert into Subject_Register 
values(8,27,1,GETDATE(),null,null,'pending');
insert into Subject_Register 
values(9,27,1,GETDATE(),null,null,'pending');
insert into Subject_Register 
values(10,27,1,GETDATE(),null,null,'done');
insert into Subject_Register 
values(14,27,1,GETDATE(),null,null,'done');
delete from Subject_Register where id = 10;




WITH PagedResults AS (
    SELECT r.id,s.name AS subject_name, r.CreatedAt, p.name AS package_name, p.original_price, r.Status,
           ROW_NUMBER() OVER (ORDER BY r.CreatedAt) AS row_num
    FROM Subject_Register r 
    LEFT JOIN subjects s ON r.SubjectId = s.id 

    LEFT JOIN package_price p ON p.id = r.PackageId
    WHERE r.UserId = 27 and s.name like '%RO%'
)
SELECT * 
FROM PagedResults
WHERE row_num BETWEEN 5 AND 10
ORDER BY row_num;