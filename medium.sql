create database medium;
use medium;

create table employees (ID int primary key, Name varchar(100) not null, Position varchar(100), Salary decimal(10,2), Hire_date date);

insert into employees values (101, 'Vivek Garg', 'Software Engineer', 75000.00, '2020-01-15'), 
                             (102, 'Khyaati Joshi', 'Project Manager', 85000.00, '2019-05-20'),
                             (103, 'Vidhi Sehrawat', 'UI/UX Designer', 70000.00, '2021-03-10'),
                             (104, 'Rajat Puri', 'Database Administrator', 80000.00, '2018-11-05'),
                             (105, 'Hiten', 'System Analyst', 72000.00, '2020-09-25');
