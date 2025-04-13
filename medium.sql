create database company;

use company;

create table employees (ID int primary key, Name varchar(50), Department varchar(50), Salary decimal(10, 2));

insert into employees values (101, 'Vivek Garg', 'HR', 50000.00),
                             (102, 'Khyaati Joshi', 'IT', 60000.00),
                             (103, 'Vidhi Sehrawat', 'Finance', 55000.00);
