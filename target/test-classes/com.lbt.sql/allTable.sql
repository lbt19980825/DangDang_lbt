--后台管理员表
drop table dd_admin
select * from dd_admin
create table dd_admin(
	id varchar2(30) primary key,
	username varchar2(30),
	password varchar2(30)
)

-------------------------------------------------------
--用户表
drop table dd_user
select * from dd_user
create table dd_user(
	id               varchar2(36) primary key,  --用户
	nickname         varchar2(60),              --昵称
	email 			 varchar2(30),              --邮箱
	password         varchar2(50),              --密码
	status           varchar2(10),              --状态
	code             varchar2(10),              --激活码
	create_date      date,                      --注册时间
	salt             varchar2(10)               --盐
)
-------------------------------------------------------
--地址表
drop table dd_address
select * from dd_address
create table dd_address(
	id               varchar2(36) primary key,  --地址id
	name             varchar2(60),              --收件人
	local 			 varchar2(100),              --详细地址
	zip_code         varchar2(6),              --邮编
	phone            varchar2(11),              --手机
	user_id          varchar2(36) references dd_user(id)               --用户id
)
------------------------------------------------------
-----订单表
drop table dd_order
select * from dd_order
create table dd_order(
	id                     varchar2(36) primary key,  --订单id
	order_name             varchar2(36),              --订单编号
	total 			       number(10,2),               --总价
	create_date            date,                      --创建时间
	address_id             varchar2(36) references dd_address(id),            --地址id
	user_id                varchar2(36) references dd_user(id),               --用户id
	name	               varchar2(36),              --收件人
	local                  varchar2(100)              --收货地址
)
---------------------------------------------------------------
---订单详情表
drop table dd_item
select * from dd_item
create table dd_item(
	id                     varchar2(36) primary key,  --订单详情id
	book_id                varchar2(36) references dd_book(id),              --图书id
	order_id 			   varchar2(36)  references dd_order(id),            --订单id
	count                  number(10),                --数量
	create_cate            date,                      --创建时间
	name                   varchar2(36),              --图书名
	cover	               varchar2(60),              --封面
	price                  number(10,2),              --原价
	dprice				   number(10,2)               --当当价
)
-----------------------------------------------------------
---分类表
drop table dd_category
select * from dd_category
create table dd_category(
   id                   varchar2(36) primary key,
   name                 varchar2(60),
   parent_id            varchar2(36) null,
   levels               varchar2(10)
);
INSERT INTO dd_category VALUES ('e3a61c36-ab29-4e92-aeeb-dd67a48d38d1', '小说', null, '1');
INSERT INTO dd_category VALUES ('e3a61c36-ab29-4e92-aeeb-dd67a48d38d3', '文艺', null, '1');
INSERT INTO dd_category VALUES ('e3a61c36-ab29-4e92-aeeb-dd67a48d38d4', '科技', null, '1');
INSERT INTO dd_category VALUES ('e3a61c36-ab29-4e92-aeeb-dd67a48d38d2', '人文社科', null, '1');
INSERT INTO dd_category VALUES ('e3a61c36-ab29-4e92-aeeb-dd67a48d38d5', '生活', null, '1');
INSERT INTO dd_category VALUES ('e3a61c36-ab29-4e92-aeeb-dd67a48d38d6', '童书', null, '1');
INSERT INTO dd_category VALUES ('e3a61c36-ab29-4e92-aeeb-dd67a48d38d7', '教育', null, '1');
INSERT INTO dd_category" VALUES ('f0dbdcb6-1857-4063-8759-090265c217c1', '官场', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d1', '2');
INSERT INTO dd_category" VALUES ('f0dbdcb6-1857-4063-8759-090265c217c2', '情感', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d1', '2');
INSERT INTO dd_category VALUES ('f0dbdcb6-1857-4063-8759-090265c217c3', '四大名著', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d1', '2');
INSERT INTO dd_category VALUES ('f0dbdcb6-1857-4063-8759-090265c217c4', '科幻小说', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d1', '2');
INSERT INTO dd_category VALUES ('f0dbdcb6-1857-4063-8759-090265c217c5', '近现代小说', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d1', '2');
INSERT INTO dd_category VALUES ('f0dbdcb6-1857-4063-8759-090265c217c6', '古典小说', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d1', '2');
INSERT INTO dd_category VALUES ('8204dcff-1425-47f6-b1a9-a1f4440527f1', '历史', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d2', '2');
INSERT INTO dd_category VALUES ('8204dcff-1425-47f6-b1a9-a1f4440527f2', '古籍', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d2', '2');
INSERT INTO dd_category VALUES ('8204dcff-1425-47f6-b1a9-a1f4440527f3', '哲学/宗教', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d2', '2');
INSERT INTO dd_category VALUES ('8204dcff-1425-47f6-b1a9-a1f4440527f4', '文化', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d2', '2');
INSERT INTO dd_category VALUES ('8204dcff-1425-47f6-b1a9-a1f4440527f5', '政治/军事', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d2', '2');
INSERT INTO dd_category VALUES ('8204dcff-1425-47f6-b1a9-a1f4440527f6', '法律', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d2', '2');
INSERT INTO dd_category VALUES ('90a11717-49c7-4b10-a95f-1d0e8926b761', '文学', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d3', '2');
INSERT INTO dd_category VALUES ('90a11717-49c7-4b10-a95f-1d0e8926b762', '传记', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d3', '2');
INSERT INTO dd_category VALUES ('90a11717-49c7-4b10-a95f-1d0e8926b763', '艺术', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d3', '2');
INSERT INTO dd_category VALUES ('90a11717-49c7-4b10-a95f-1d0e8926b764', '摄影', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d3', '2');
INSERT INTO dd_category VALUES ('c4b646de-8dd0-4f3a-a06f-73cb97ab8571', '科普', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d4', '2');
INSERT INTO dd_category VALUES ('c4b646de-8dd0-4f3a-a06f-73cb97ab8572', '建筑', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d4', '2');
INSERT INTO dd_category VALUES ('c4b646de-8dd0-4f3a-a06f-73cb97ab8573', '医学', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d4', '2');
INSERT INTO dd_category VALUES ('c4b646de-8dd0-4f3a-a06f-73cb97ab8574', '计算机', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d4', '2');
INSERT INTO dd_category VALUES ('c4b646de-8dd0-4f3a-a06f-73cb97ab8575', '农林', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d4', '2');
INSERT INTO dd_category VALUES ('c4b646de-8dd0-4f3a-a06f-73cb97ab8576', '自然科学', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d4', '2');
INSERT INTO dd_category VALUES ('5e4ea8c8-97b8-4b8b-8da2-f8e881b4a461', '两性', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d5', '2');
INSERT INTO dd_category VALUES ('5e4ea8c8-97b8-4b8b-8da2-f8e881b4a462', '孕期', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d5', '2');
INSERT INTO dd_category VALUES ('5e4ea8c8-97b8-4b8b-8da2-f8e881b4a463', '育儿', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d5', '2');
INSERT INTO dd_category VALUES ('5e4ea8c8-97b8-4b8b-8da2-f8e881b4a464', '亲自/家教', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d5', '2');
INSERT INTO dd_category VALUES ('5e4ea8c8-97b8-4b8b-8da2-f8e881b4a465', '保健', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d5', '2');
INSERT INTO dd_category VALUES ('5e4ea8c8-97b8-4b8b-8da2-f8e881b4a466', '运动', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d5', '2');
INSERT INTO dd_category VALUES ('5e4ea8c8-97b8-4b8b-8da2-f8e881b4a467', '家居', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d5', '2');
INSERT INTO dd_category VALUES ('79a263c5-b609-473e-85c8-aa351c56cc51', '0-2', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d6', '2');
INSERT INTO dd_category VALUES ('79a263c5-b609-473e-85c8-aa351c56cc52', '3-6', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d6', '2');
INSERT INTO dd_category VALUES ('79a263c5-b609-473e-85c8-aa351c56cc53', '7-10', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d6', '2');
INSERT INTO dd_category VALUES ('79a263c5-b609-473e-85c8-aa351c56cc54', '11-14', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d6', '2');
INSERT INTO dd_category VALUES ('79a263c5-b609-473e-85c8-aa351c56cc55', '绘本', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d6', '2');
INSERT INTO dd_category VALUES ('79a263c5-b609-473e-85c8-aa351c56cc56', '英语', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d6', '2');
INSERT INTO dd_category VALUES ('4fe9388b-b672-4640-8078-d36d40772ad1', '教材', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d7', '2');
INSERT INTO dd_category VALUES ('4fe9388b-b672-4640-8078-d36d40772ad2', '外语', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d7', '2');
INSERT INTO dd_category VALUES ('4fe9388b-b672-4640-8078-d36d40772ad3', '考试', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d7', '2');
INSERT INTO dd_category VALUES ('4fe9388b-b672-4640-8078-d36d40772ad4', '中小学教辅', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d7', '2');
INSERT INTO dd_category VALUES ('4fe9388b-b672-4640-8078-d36d40772ad5', '工具书', 'e3a61c36-ab29-4e92-aeeb-dd67a48d38d7', '2');
commit;
----------------------------------------------------------------------
----图书表
 drop table dd_book
 select * from dd_book 
 CREATE TABLE dd_book (
id VARCHAR2(40 BYTE) primary key NOT NULL ,
name VARCHAR2(90 BYTE)  ,
author VARCHAR2(90 BYTE)  ,
cover VARCHAR2(40 BYTE) ,
press VARCHAR2(90 BYTE),
press_date DATE ,
edition VARCHAR2(30 BYTE) ,
print_date DATE NULL ,
impression VARCHAR2(30 BYTE)  ,
isbn VARCHAR2(20 BYTE)  ,
word_num NUMBER(10)  ,
page_num NUMBER(10)  ,
sizes VARCHAR2(30 BYTE)  ,
paper VARCHAR2(30 BYTE)  ,
pack VARCHAR2(30 BYTE)  ,
price FLOAT NULL ,
dprice FLOAT NULL ,
create_date DATE NULL ,
editior_recommend VARCHAR2(4000 BYTE) ,
content_abstract VARCHAR2(4000 BYTE),
author_abstract VARCHAR2(4000 BYTE),
director VARCHAR2(4000 BYTE) NULL ,
media_commentary VARCHAR2(4000 BYTE),
category_id VARCHAR2(40 BYTE) references dd_category(id),
sale NUMBER(10)  ,
stock NUMBER(10)
)
---------------------------------------------------------------------
-------订单详情表
drop table dd_item
select * from dd_item
create table dd_item(
	id                     varchar2(36) primary key,  --订单详情id
	book_id                varchar2(36) references dd_book(id),              --图书id
	order_id 			         varchar2(36)  references dd_order(id),            --订单id
	count                  number(10),                --数量
	create_cate            date,                      --创建时间
	name                   varchar2(100),              --图书名
	cover	                 varchar2(60),              --封面
	price                  number(10,2),              --原价
	dprice				         number(10,2)               --当当价
)