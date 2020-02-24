--后台管理员表
drop table dd_admin
create table dd_admin(
	id varchar2(30) primary key,
	username varchar2(30),
	password varchar2(30)
)
select * from dd_admin
insert into dd_admin values('1','lbt','lbt')




--用户表
drop table dd_user
select * from dd_user
delete dd_user where id='d3ed5600-cefa-4df2-8770-e16aa7ca0f07'
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
delete dd_address where id='c25310d1-3a9f-4d66-bc4d-9def31f08ee9'
insert into dd_address values('1','罗伯特','天津市北辰区','300400','15620178661','02d0cd3d-3199-4553-a976-eeddc0a3fa63')

---订单表
select * from dd_item where order_id = 'd64a7058-0272-4124-aaea-02390b007ba7'
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
---订单详情表
drop table dd_item
select * from dd_item
create table dd_item(
	id                     varchar2(36) primary key,  --订单详情id
	book_id                varchar2(36) references dd_book(id),              --图书id
	order_id 			   varchar2(36)  references dd_order(id),            --订单id
	count                  number(10),                --数量
	create_cate            date,                      --创建时间
	name                   varchar2(100),              --图书名
	cover	               varchar2(60),              --封面
	price                  number(10,2),              --原价
	dprice				   number(10,2)               --当当价
)



---分类表
drop table dd_category
select * from dd_category
select * from dd_category  order by id where name='小说'
delete dd_category where id ='2fa8934e-1d81-4c75-9b18-faa5c21c755a'

 	select f.id fid,f.name fname,f.levels flevels,s.id sid,s.name sname,s.levels slevels
 			   from dd_category f left join dd_category s
 			   on f.id=s.parent_id
 			   where f.levels='1' and f.id='e3a61c36-ab29-4e92-aeeb-dd67a48d38d1'
		

select name from dd_category where id='f0dbdcb6-1857-4063-8759-090265c217c5'
delete dd_category where id='3'
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
select f.id fid,f.name fname,f.levels,s.id sid,s.name sname
	   from dd_category f left join dd_category s
	   on f.parent_id=s.id 
	   alter table dd_category drop constraint PK_DD_CATEGORY
	   delete from dd_category where id='1'

 ---查所有一级类别名
select name from dd_category where levels='1'

 		select f.id fid,f.name fname,f.levels flevels,s.id sid,s.name sname,s.levels slevels
 			   from dd_category f left join dd_category s
 			   on f.id=s.parent_id
 			   where f.levels='1' and f.id='e3a61c36-ab29-4e92-aeeb-dd67a48d38d1'
 			   


select * from dd_category where levels='1'
----图书表

 drop table dd_book
 select * from dd_book 
 
 select * from dd_book  order by dprice desc
 update  dd_book set create_date=to_date('2019-06-04 08:00:00','yyyy-mm-dd hh:mi:ss') where  id='f5aa83a8-149d-46ff-9173-3a4ab1ed837d'


 update dd_book set sale='70' where id='2bafab75-e445-4412-ad2f-539678f8dcad'
 select * from dd_book where category_id='4fe9388b-b672-4640-8078-d36d40772ad5'
  		select b.* from (select * from dd_book order by create_date desc) b  where  rownum between 1 and 8
 
  		select b.* from(select * from dd_book order by create_date,sale desc) b where rownum between 1 and 8
 
 select id,name,author,price,dprice,press,press_date,cover,stock,sale from dd_book 
 select name,author from dd_book where name like '%v%'

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
delete dd_book where id='1'
insert into  dd_book values ('1111', '儒林外史', '吴敬梓', 'rlws.jpg', '花山文艺出版社', TO_DATE('2015-07-01 16:30:34', 'YYYY-MM-DD HH24:MI:SS'), '第三版', TO_DATE('2018-12-12 16:32:08', 'YYYY-MM-DD HH24:MI:SS'), '第五次印刷', '9787551123426', '50000', '500', '16开', '胶版纸', '精装', '12', '10', TO_DATE('2019-01-07 16:34:07', 'YYYY-MM-DD HH24:MI:SS'), '《儒林外史》，是一部描绘知识分子群像的长篇讽刺小说。作品描写了深受八股毒害的儒生的种种荒诞与虚伪行为。', '《儒林外史》，是一部描绘知识分子群像的长篇讽刺小说。作品描写了深受八股毒害的儒生的种种荒诞与虚伪行为。', '吴敬梓（1701-1754），汉族，安徽全椒人，清代最伟大的小说家之一。生活于“康乾盛世”时期，自幼聪慧好学。23岁时，考取秀才，当年其父吴霖起失官、病故。此后，他科场不顺，并经历了近亲掠夺祖产的事情，目睹了官场斗争的残酷。他开始挥金如土、纵情享乐，终致家财散尽。33岁时移居南京，生活清贫，喜交高雅之士，对热衷功名者嗤之以鼻。35岁时，决定放弃科考，并开始创作《儒林外史》。历13年书成，后坚持修改，直至54岁病逝。', '第　一　回 说楔子敷陈大义 借名流隐括全文 001
第　二　回 王孝廉村学识同科 周蒙师暮年登上第 007
第　三　回 周学道校士拔真才 胡屠户行凶闹捷报 012
第　四　回 荐亡斋和尚吃官司 打秋风乡绅遭横事 019
第　五　回 秀才议立偏房 严监生疾终正寝 024
第　六　回 乡绅发病闹船家 寡妇含冤控大伯 030
第　七　回 范学道视学报师恩 王员外立朝敦友谊 036
第　八　回 王观察穷途逢世好 娄公子故里遇贫交 041
第　九　回 娄公子捐金赎朋友 刘守备冒姓打船家 046
第　十　回 鲁翰林怜才择婿 蘧公孙富室招亲 052
第 十 一 回 鲁小姐制义难新郎 杨司训相府荐贤士 057
第 十 二 回 名士大宴莺脰湖 侠客虚设人头会 062
第 十 三 回 蘧夫求贤问业 马纯上仗义疏财 067
第 十 四 回 蘧公孙书坊送良友 马秀才山洞遇神仙 073
第 十 五 回 葬神仙马秀才送丧 思父母匡童生尽孝 078
第 十 六 回 大柳庄孝子事亲 乐清县贤宰爱士 083
第 十 七 回 匡秀才重游旧地 赵医生高踞诗坛 088
第 十 八 回 约诗会名士携匡二 访朋友书店会潘三 093
第 十 九 回 匡超人幸得良朋 潘自业横遭祸事 098
第 二 十 回 匡超人高兴长安道 牛布衣客死芜湖关 103
第二十一回 冒姓字小子求名 念亲戚老夫卧病 108
第二十二回 认祖孙玉圃联宗 爱交游雪斋留客 113
第二十三回 发阴私诗人被打 叹老景寡妇寻夫 119
第二十四回 牛浦郎牵连多讼事 鲍文卿整理旧生涯 125
第二十五回 鲍文卿南京遇旧 倪廷玺安庆招亲 130
第二十六回 向观察升官哭友 鲍廷玺丧父娶妻 135
第二十七回 王太太夫妻反目 倪廷珠兄弟相逢 140
第二十八回 季苇萧扬州入赘 萧金铉白下选书 145
第二十九回 诸葛佑僧寮遇友 杜慎卿江郡纳姬 150
第 三 十 回 爱少俊访友神乐观 逞风流高会莫愁湖 155
第三十一回 天长县同访豪杰 赐书楼大醉高朋 160
第三十二回 杜少卿平居豪举 娄焕文临去遗言 166
第三十三回 杜少卿夫妇游山 迟衡山朋友议礼 171
第三十四回 议礼乐名流访友 备弓旌天子招贤 176
第三十五回 圣天子求贤问道 庄征君辞爵还家 182
第三十六回 常熟县真儒降生 泰伯祠名贤主祭 187
第三十七回 祭先圣南京修礼 送孝子西蜀寻亲 192
第三十八回 郭孝子深山遇虎 甘露僧狭路逢仇 198
第三十九回 萧云仙救难明月岭 平少保奏凯青枫城 203
第 四 十 回 萧云仙广武山赏雪 沈琼枝利涉桥卖文 208
第四十一回 庄濯江话旧秦淮河 沈琼枝押解江都县 214
第四十二回 公子妓院说科场 家人苗疆报信息 219
第四十三回 野羊塘将军大战 歌舞地酋长劫营 224
第四十四回 汤总镇成功归故乡 余明经把酒问葬事 229
第四十五回 敦友谊代兄受过 讲堪舆回家葬亲 234
第四十六回 三山门贤人饯别 五河县势利熏心 239
第四十七回 虞秀才重修元武阁 方盐商大闹节孝祠 244
第四十八回 徽州府烈妇殉夫 泰伯祠遗贤感旧 249
第四十九回 翰林高谈龙虎榜 中书冒占凤凰池 254
第 五 十 回 假官员当街出丑 真义气代友求名 259
第五十一回 少妇骗人折风月 壮士高兴试官刑 263
第五十二回 比武艺公子伤身 毁厅堂英雄讨债 267
第五十三回 国公府雪夜留宾 来宾楼灯花惊梦 272
第五十四回 病佳人青楼算命 呆名士妓馆献诗 277
第五十五回 添四客述往思来 弹一曲高山流水 283
第五十六回 神宗帝下诏旌贤 刘尚书奉旨承祭 288', '秉持公心，指摘时弊。机锋所向，尤在士林；其文又戚而能谐，婉而多讽。
——鲁迅
《儒林外史》是一部主角不断变换的长篇小说，其艺术特色堪称“精工提炼”。
——胡适
《儒林外史》里虽然没有一个*人称在那里穿线，但似乎有一个“我”在。这个“我”，把自己所历种种，老老实实地写了出来。
——张天翼', 'f0dbdcb6-1857-4063-8759-090265c217c6', 0, 1000);
INSERT INTO dd_book VALUES ('5', '金瓶梅', '兰陵笑笑生', 'jpm.jpg', '吉林大学出版社', TO_DATE('2015-07-01 16:30:34', 'YYYY-MM-DD HH24:MI:SS'), '第三版', TO_DATE('2018-12-12 16:32:08', 'YYYY-MM-DD HH24:MI:SS'), '第五次印刷', '9787551123426', '50000', '500', '16开', '胶版纸', '精装', '125', '120', TO_DATE('2019-01-07 16:34:07', 'YYYY-MM-DD HH24:MI:SS'), '中国伟大的写实小说，有明一代的百科全书，古代小说史上里程碑性质的作品，开拓了中国小说史的新阶段。没有《金瓶梅》，就产生不了《红楼梦》，《金瓶梅》与《红楼梦》是中华民族的骄傲，可以与世界*伟大的小说相媲美。 ', '中国伟大的写实小说 有明一代的百科全书 开拓了中国小说史上的新阶段', '作者很低调，没有做简介', '第一回
西门庆热结十兄弟 武二郎冷遇亲哥嫂
第二回
俏潘娘帘下勾情 老王婆茶坊说技
第三回
定挨光王婆受贿 设圈套浪子私挑
第四回
赴巫山潘氏幽欢 闹茶坊郓哥义愤
第五回
捉奸情郓哥定计 饮酰药武大遭殃
第六回
何九受贿瞒天 王婆帮闲遇雨
第七回
薛媒婆说娶孟三儿 杨姑娘气骂张四舅
第八回
盼情郎佳人占鬼卦 烧夫灵和尚听淫声
第九回
西门庆偷娶潘金莲 武都头误打李皂隶
第十回
义士充配孟州道 妻妾玩赏芙蓉亭', '媒体也说很好看的一本书', '8204dcff-1425-47f6-b1a9-a1f4440527f2', 0, 1000);