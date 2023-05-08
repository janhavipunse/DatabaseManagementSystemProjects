create database hbm;
use hbm;

create table login(username varchar(25) primary key, password varchar(25));
insert into login values('admin', '12345');
select * from login;

create table employee(name varchar(25), age varchar(10), gender varchar(15), job varchar(30), salary varchar(15), phone varchar(15), email varchar(40), aadhar varchar(20) primary key);
insert into employee values('Ravi Sharma', '43','Male','Manager','68000','9845235562','ravisharma@gmail.com','234311558765');
select * from employee;

create table room(roomnumber varchar(10) primary key, availability varchar(20), price varchar(20), bed_type varchar(20));
insert into room values('101','Available','2200','Single');
insert into room values('102','Available','2000','Single');
insert into room values('103','Available','1900','Single');
insert into room values('104','Available','3000','Double');
insert into room values('105','Available','2300','Single');
insert into room values('106','Available','3500','Double');
insert into room values('107','Available','3200','Double');
insert into room values('108','Available','2800','Double');
insert into room values('109','Available','1700','Single');
insert into room values('110','Available','2500','Double');
select * from room;

create table customer( Aadharnumber varchar(30) Primary Key, name varchar(30), gender varchar(15), city varchar(20));
select * from customer;

create table Book(room varchar(10), checkintime varchar(80), deposit varchar(20),custAadhar varchar(30), Foreign key (room) References room(roomnumber),Foreign key (custAadhar) References customer(Aadharnumber));
select * from Book;

create table department(department varchar(30), budget varchar(30));
insert into department values('Housekeeping','10000');
insert into department values('Front Office','20000');
insert into department values('Kitchen or Food Production','180000');
insert into department values('Security','120000');
insert into department values('Accounts and Credits','150000');

insert into login values('admin2','0000');

ALTER TABLE book
ADD CONSTRAINT book
FOREIGN KEY (custAadhar) REFERENCES customer (AadharNumber)
ON DELETE CASCADE;



