create database CMS2;
use CMS2;


create table Users(
user_id int auto_increment not null,
fullname varchar(225),
email varchar(50),
mobile varchar(20),
password varchar(225),
user_status varchar(225),

primary key (user_id)
);

create table Clients(
client_id int auto_increment not null,
client_name varchar(225),
client_email varchar(50),
client_mobile varchar(20),
password varchar(225),
client_status varchar(225),
primary key (client_id)
);

create table Admins(
admin_id int auto_increment not null,
admin_name varchar(225),
admin_email varchar(225),
admin_mobile varchar(20),
password varchar(225),
admin_status varchar(225),
primary key (admin_id)
);

-- drop table Users;

create table Roles(

role_id int auto_increment not null,
rolename varchar(225),
role_desc varchar(150),
primary key(role_id)
);



-- drop table Roles;

create table userRole(
userRoleId  int(255) not null auto_increment primary key,
user_id int not null,
role_id int not null,
role_status varchar(50),
created_at varchar(50),
updated_at varchar(50),
foreign key(user_id) references Users(user_id),
foreign key(role_id) references Roles(role_id)

);



-- drop table userRole;

create table menu(
menu_id int auto_increment,
menu_name varchar(225),
menu_desc varchar(150),
controller varchar(225),
functions varchar(225),
primary key(menu_id)

);

-- drop table permission;

create table role_menu(
id_role_menu int(255) not null auto_increment primary key,
menu_id int not null,
role_id int not null,
menu_status varchar(50),

foreign key(menu_id) references menu(menu_id),
foreign key(role_id) references Roles(role_id)
);


-- drop table role_permission;

create table news(
news_id int auto_increment not null,
url varchar(225),
title varchar(225),
news_desc varchar(150),
content longtext,
news_status varchar(50),
is_hot varchar(50),
user_id int,
approver_id int not null,
created_at varchar(50),
updated_at varchar(50),
approved_at varchar(50),
primary key(news_id),
foreign key(user_id) references Users(user_id)

);

-- drop table news;

create table slider(
slider_id int auto_increment,
primary key (slider_id)
);

-- drop table slider;

-- insert sample record to Users table
insert into Users(fullname, email, mobile, password, user_status) values ('Mai Hoang Anh', 'hoanganh@gmail.com', '0988310050', '12345678', 'deactived');
insert into Users(fullname, email, mobile, password, user_status) values ('Mai Xuan Huu', 'huumx@fsoft.com.vn', '0983357662', '12345890', 'actived');
insert into Users(fullname, email, mobile, password, user_status) values ('Trinh Thi Hai Yen', 'yentth7@fsoft.com.vn', '01675720262', '20000888', 'actived');
insert into Users(fullname, email, mobile, password, user_status) values ('Pham Tuan Anh', 'anhpt28@fsoft.com.vn', '0989123074', '1346789','online');
insert into Users(fullname, email, mobile, password, user_status) values ('Hoang Huy Trung', 'trung.huster@gmail.com', '0972345697', '000188384737734','offline');

select * from Users;

-- insert sample record to role table
insert into Roles(rolename, role_desc) values ('HR', 'not null');
insert into Roles(rolename, role_desc) values ('Dev', 'Java');
insert into Roles(rolename, role_desc) values ('Dev', 'Python');
insert into Roles(rolename, role_desc) values ('Admin', 'Java09');
insert into Roles(rolename, role_desc) values ('Admin', '.Net07');

select * from Roles;

-- insert sample record to userRole table
-- insert into userRole(user_id, role_id, role_status, created_at, updated_at) values (1, 2, 'active', '2018-02-02', '2018-09-09');
-- insert into userRole(user_id, role_id, role_status, created_at, updated_at) values(2, 3, 'deactive', '2007-09-09', '2012-12-12');
-- insert into userRole(user_id, role_id, role_status, created_at, updated_at) values (3, 1, 'active', '2018-05-05', '2018-06-06');
-- insert into userRole(user_id, role_id, role_status, created_at, updated_at) values(4, 4, 'active', '2018-12-12', null);
-- insert into userRole(user_id, role_id, role_status, created_at, updated_at) values(5, 5, 'deactive', null, '2018-02-07');

select * from menu;
-- insert sample record to permission table
-- insert into menu (menu_name, menu_desc, controller, functions) values ('updater', 'update list of news', 'updaterController', 'update');
-- insert into menu (menu_name, menu_desc, controller, functions) values ('writer', 'write news', 'writerController', 'insert');
-- insert into menu (menu_name, menu_desc, controller, functions)values ('admin', 'manage apps', 'adminControler', 'listAll');
-- insert into menu (menu_name, menu_desc, controller, functions)values ('approver', 'approve news', 'approverController', 'approve');
-- insert into menu (menu_name, menu_desc, controller, functions)values ('auditor', 'audit news', 'auditorController', 'audit');

-- insert sample record to role_permission table
select * from role_menu;

-- insert into role_menu (menu_id, role_id, menu_status) values (1, 2, 'waiting');
-- insert into role_menu (menu_id, role_id, menu_status) values (2, 2, 'approved');
-- insert into role_menu (menu_id, role_id, menu_status) values (2, 3, 'approved');
-- insert into role_menu (menu_id, role_id, menu_status) values (3, 5, 'denied');
-- insert into role_menu (menu_id, role_id, menu_status) values (3, 4, 'waiting');

-- delete from role_menu;
-- insert into sample record to news table

-- insert into news(url, title, news_desc, content, news_status, is_hot, user_id, approver_id, created_at, updated_at, approved_at) values ('/weibo.com.vn', 'Hot news for girls', 'Unbelievable', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry', 'updated', 'very hot',1, 2, '2018-12-11', '2018-12-12', '2018-12-12');

-- insert into news(url, title, news_desc, content, news_status, is_hot, user_id, approver_id, created_at, updated_at, approved_at) values('/url.com', 'News for boys', 'Ubelievable', 'hen an unknown printer took a galley of type and scrambled it to make a type specimen book', 'awaiting', 'hot', 1, 3, '2018-12-12', '2018-12-13', '2018-12-14');

-- insert into news(url, title, news_desc, content, news_status, is_hot, user_id, approver_id, created_at, updated_at, approved_at) values ('/fabo.com', 'Woman will be more preciated', 'good news for woman', 'It was popularised in the 1960s with the release of Letraset sheets', 'publisher=d', 'normal', 2, 3,'2018-11-13', '2018-11-14', '2018-11-15');

-- insert into news(url, title, news_desc, content, news_status, is_hot, user_id, approver_id, created_at, updated_at, approved_at) values ('/dantri.com', 'Gia xang tang cao', 'Bad news', 'more recently with desktop publishing software like Aldus PageMaker', 'published','very very hot', 3, 5, '2018-12-11', '2018-12-12', '2018-12-12');

-- insert into news(url, title, news_desc, content, news_status, is_hot, user_id, approver_id, created_at, updated_at, approved_at) values ('/hocthuc.vn', 'Hoc Java', 'Hoc tap', 'It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old', 'denied', 'normal', 4, 5, '2018-09-08', '2018-09-09', '2018-09-14');

select * from news;





 