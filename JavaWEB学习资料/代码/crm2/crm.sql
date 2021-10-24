drop table if exists t_customer;

create table t_customer(
	id int(10) primary key auto_increment,
	realname varchar(32) not null,
	birth char(10),
	sex char(1),
	tel varchar(20)
);

