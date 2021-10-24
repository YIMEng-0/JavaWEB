drop table if exists t_user;
create table t_user(
	id int(10) primary key auto_increment,
	username varchar(32) not null
);
