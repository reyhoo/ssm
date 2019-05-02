drop table if exists t_role;
create table t_role (id bigint primary key auto_increment,role_name varchar(50) not null,note varchar(512) not null);

insert into t_role(role_name,note)values('role_name1','note1');
insert into t_role(role_name,note)values('role_name2','note2');
insert into t_role(role_name,note)values('role_name3','note3');
insert into t_role(role_name,note)values('role_name4','note4');
insert into t_role(role_name,note)values('role_name5','note5');
insert into t_role(role_name,note)values('role_name6','note6');
insert into t_role(role_name,note)values('role_name7','note7');
insert into t_role(role_name,note)values('role_name8','note8');
insert into t_role(role_name,note)values('role_name9','note9');
insert into t_role(role_name,note)values('role_name10','note10');
insert into t_role(role_name,note)values('role_name11','note11');
insert into t_role(role_name,note)values('role_name12','note12');
insert into t_role(role_name,note)values('role_name13','note13');
insert into t_role(role_name,note)values('role_name14','note14');
insert into t_role(role_name,note)values('role_name15','note15');

 select * from t_role;

delete from t_role;


drop table if exists t_user;
create table t_user(
	id bigint primary key auto_increment,
	user_name varchar(50) not null,
	password varchar(50) not null,
	sex int not null,
	mobile varchar(50) not null,
	tel varchar(50) not null,
	email varchar(50) not null,
	note varchar(256) not null
);	
insert into t_user(user_name,password,sex,mobile,tel,email,note)
values('tom','123456',1,'131','110','tom@qq.com','tom..note');
insert into t_user(user_name,password,sex,mobile,tel,email,note)
values('lucy','123456',0,'151','112','lucy@qq.com','lucy..note');



drop table if exists t_user2;
create table t_user2(
	id bigint primary key auto_increment,
	user_name varchar(50) not null,
	real_name varchar(50) not null,
	sex int not null,
	mobile varchar(50) not null,
	email varchar(50) not null,
	note varchar(256) not null
);	

insert into t_user2(user_name,real_name,sex,mobile,email,note)
values('user1','r_user1',1,'131','tom@qq.com','user1..note');
insert into t_user2(user_name,real_name,sex,mobile,email,note)
values('user2','r_user2',0,'131','tom@qq.com','user2..note');
insert into t_user2(user_name,real_name,sex,mobile,email,note)
values('user3','r_user3',1,'131','tom@qq.com','user3..note');
insert into t_user2(user_name,real_name,sex,mobile,email,note)
values('user4','r_user4',0,'131','tom@qq.com','user4..note');
insert into t_user2(user_name,real_name,sex,mobile,email,note)
values('user5','r_user4',0,'131','tom@qq.com','user4..note');
insert into t_user2(user_name,real_name,sex,mobile,email,note)
values('user6','r_user4',0,'131','tom@qq.com','user4..note');
insert into t_user2(user_name,real_name,sex,mobile,email,note)
values('user7','r_user4',0,'131','tom@qq.com','user4..note');
insert into t_user2(user_name,real_name,sex,mobile,email,note)
values('user8','r_user4',0,'131','tom@qq.com','user4..note');
insert into t_user2(user_name,real_name,sex,mobile,email,note)
values('user9','r_user4',0,'131','tom@qq.com','user4..note');
insert into t_user2(user_name,real_name,sex,mobile,email,note)
values('user10','r_user4',0,'131','tom@qq.com','user4..note');
insert into t_user2(user_name,real_name,sex,mobile,email,note)
values('user11','r_user4',0,'131','tom@qq.com','user4..note');
insert into t_user2(user_name,real_name,sex,mobile,email,note)
values('user12','r_user4',0,'131','tom@qq.com','user4..note');
insert into t_user2(user_name,real_name,sex,mobile,email,note)
values('user13','r_user4',0,'131','tom@qq.com','user4..note');

drop table if exists t_role_user;
create table t_role_user(
	id bigint primary key auto_increment,
	role_id bigint not null,
	user_id bigint not null
);
alter table t_role_user add constraint fk1_role foreign key(role_id) references t_role (id)
on delete restrict on update restrict;

alter table t_role_user add constraint fk_user foreign key(user_id) references t_user (id)
on delete restrict on update restrict;




drop table if exists t_role_user2;
create table t_role_user2(
	id bigint primary key auto_increment,
	role_id bigint not null,
	user_id bigint not null
);
alter table t_role_user2 add constraint fk_role foreign key(role_id) references t_role (id)
on delete restrict on update restrict;

alter table t_role_user2 add constraint fk_user2 foreign key(user_id) references t_user2 (id)
on delete restrict on update restrict;
insert into t_role_user2 (role_id,user_id)values(1,12);
insert into t_role_user2 (role_id,user_id)values(1,13);
insert into t_role_user2 (role_id,user_id)values(1,10);
insert into t_role_user2 (role_id,user_id)values(2,5);
insert into t_role_user2 (role_id,user_id)values(2,9);
insert into t_role_user2 (role_id,user_id)values(3,10);
insert into t_role_user2 (role_id,user_id)values(3,11);
insert into t_role_user2 (role_id,user_id)values(4,9);
insert into t_role_user2 (role_id,user_id)values(4,6);
insert into t_role_user2 (role_id,user_id)values(5,8);
insert into t_role_user2 (role_id,user_id)values(5,10);
insert into t_role_user2 (role_id,user_id)values(5,6);
insert into t_role_user2 (role_id,user_id)values(6,7);
insert into t_role_user2 (role_id,user_id)values(6,8);
insert into t_role_user2 (role_id,user_id)values(6,9);


select r.id,r.role_name,r.note
		from 
		t_user2 u
		left join t_role_user2 ru on u.id = ru.user_id
		left join t_role r on r.id = ru.role_id where u.id= 9;


drop table if exists t_female_health_form;
drop table if exists t_male_health_form;
drop table if exists t_employee_task;
drop table if exists t_task;
drop table if exists t_work_card;
drop table if exists t_employee;

create table t_employee(
	id bigint primary key auto_increment,
	real_name varchar(60) not null,
	sex int(2) not null,
	birthday date not null,
	mobile varchar(20) not null,
	email varchar(60) not null,
	position varchar(60) not null,
	note varchar(256)
);
create table t_employee_task(
	id bigint primary key auto_increment,
	emp_id bigint not null,
	task_id bigint not null,
	task_name varchar(60)not null,
	note varchar(256)
);
create table t_female_health_form(
	id bigint primary key auto_increment,
	emp_id bigint not null,
	heart varchar(64) not null,
	liver varchar(64) not null,
	spleen varchar(64) not null,
	lung varchar(64) not null,
	kidney varchar(64) not null,
	uterus varchar(64) not null,
	note varchar(256) 
);
create table t_male_health_form(
	id bigint primary key auto_increment,
	emp_id bigint not null,
	heart varchar(64) not null,
	liver varchar(64) not null,
	spleen varchar(64) not null,
	lung varchar(64) not null,
	kidney varchar(64) not null,
	prostate varchar(64) not null,
	note varchar(256) 
);
create table t_task(
	id bigint not null,
	title varchar(60) not null,
	context varchar(256) not null,
	note varchar(256),
	primary key(id)
);
create table t_work_card(
	id bigint primary key auto_increment,
	emp_id bigint not null,
	real_name varchar(60) not null,
	department varchar(60) not null,
	mobile varchar(60) not null,
	position varchar(60) not null,
	note varchar(256)
);

alter table t_work_card add constraint fk_emp_work_card
foreign key (emp_id) references t_employee(id) on delete restrict on update restrict;

alter table t_employee_task add constraint fk_emp_emplyee_task
foreign key (emp_id) references t_employee(id) on delete restrict on update restrict;

alter table t_employee_task add constraint fk_task_emplyee_task
foreign key (task_id) references t_task(id) on delete restrict on update restrict;


alter table t_male_health_form add constraint fk_emp_male_health
foreign key (emp_id) references t_employee(id) on delete restrict on update restrict;

alter table t_female_health_form add constraint fk_emp_female_health
foreign key (emp_id) references t_employee(id) on delete restrict on update restrict;



insert into t_employee(real_name,sex,birthday,mobile,email,position,note)
values('tom',1,'1982-04-08','19928738383','tom@qq.com','市场专员','good good');
insert into t_work_card(emp_id,real_name,department,mobile,position,note)
values(1,'tom','市场部','19928738383','市场专员','good good');

insert into t_employee(real_name,sex,birthday,mobile,email,position,note)
values('jerry',1,'1989-08-08','110','jerry@qq.com','销售员','bad bad');
insert into t_work_card(emp_id,real_name,department,mobile,position,note)
values(2,'jerry','销售部','110','销售员','bad bad');

insert into t_employee(real_name,sex,birthday,mobile,email,position,note)
values('terry',1,'1990-04-01','132','terry@qq.com','工程师','handsome');
insert into t_work_card(emp_id,real_name,department,mobile,position,note)
values(3,'terry','工程部','19928738383','工程师','handsome');

insert into t_employee(real_name,sex,birthday,mobile,email,position,note)
values('lucy',0,'1982-04-08','19928738383','lucy@qq.com','市场专员','lucy good good');
insert into t_work_card(emp_id,real_name,department,mobile,position,note)
values(4,'lucy','市场部','19928738383','市场专员','lucy good good');

insert into t_employee(real_name,sex,birthday,mobile,email,position,note)
values('lily',0,'1982-04-08','19928738383','lily@qq.com','市场专员','lily good good');
insert into t_work_card(emp_id,real_name,department,mobile,position,note)
values(5,'lily','市场部','19928738383','市场专员','lily good good');

insert into t_employee(real_name,sex,birthday,mobile,email,position,note)
values('liming',1,'1982-04-08','19928738383','liming@qq.com','市场专员','good good');
insert into t_work_card(emp_id,real_name,department,mobile,position,note)
values(6,'liming','市场部','19928738383','市场专员','good good');


insert into t_task(id,title,context,note)values(1,'task1title','task1context','task1note');
insert into t_task(id,title,context,note)values(2,'task2title','task2context','task2note');
insert into t_task(id,title,context,note)values(3,'task3title','task3context','task3note');
insert into t_task(id,title,context,note)values(4,'task4title','task4context','task4note');
insert into t_task(id,title,context,note)values(5,'task5title','task5context','task5note');
insert into t_task(id,title,context,note)values(6,'task6title','task6context','task6note');
insert into t_task(id,title,context,note)values(7,'task7title','task7context','task7note');
insert into t_task(id,title,context,note)values(8,'task8title','task8context','task8note');

insert into t_employee_task (emp_id,task_id,task_name,note)values(1,3,'task3context','task3note');
insert into t_employee_task (emp_id,task_id,task_name,note)values(1,8,'task8context','task8note');
insert into t_employee_task (emp_id,task_id,task_name,note)values(4,3,'task3context','task3note');
insert into t_employee_task (emp_id,task_id,task_name,note)values(5,6,'task6context','task6note');
insert into t_employee_task (emp_id,task_id,task_name,note)values(5,1,'task1context','task1note');
insert into t_employee_task (emp_id,task_id,task_name,note)values(5,2,'task2context','task2note');
insert into t_employee_task (emp_id,task_id,task_name,note)values(3,7,'task7context','task7note');

insert into t_female_health_form (emp_id,heart,liver,spleen,lung,kidney,uterus,note)
values(4,'lucy heart','lucy liver','lucy spleen','lucy lung','lucy kidney','lucy uterus','lucy note');
insert into t_female_health_form (emp_id,heart,liver,spleen,lung,kidney,uterus,note)
values(5,'lily heart','lily liver','lily spleen','lily lung','lily kidney','lily uterus','lily note');
insert into t_male_health_form (emp_id,heart,liver,spleen,lung,kidney,prostate,note)
values(1,'tom heart','tom liver','tom spleen','tom lung','tom kidney','tom prostate','tom note');
insert into t_male_health_form (emp_id,heart,liver,spleen,lung,kidney,prostate,note)
values(2,'jerry heart','jerry liver','jerry spleen','jerry lung','jerry kidney','jerry prostate','jerry note');
insert into t_male_health_form (emp_id,heart,liver,spleen,lung,kidney,prostate,note)
values(3,'terry heart','terry liver','terry spleen','terry lung','terry kidney','terry prostate','terry note');
insert into t_male_health_form (emp_id,heart,liver,spleen,lung,kidney,prostate,note)
values(6,'liming heart','liming liver','liming spleen','liming lung','liming kidney','liming prostate','liming note');


select emp.id,emp.real_name,emp.sex,emp.birthday,emp.mobile,emp.email,emp.position,emp.note,
		if(emp.sex = 1,mhf.id,fhf.id) as h_id,
		if(emp.sex = 1,mhf.heart,fhf.heart) as h_heart,
		if(emp.sex = 1,mhf.liver,fhf.liver) as h_liver,
		if(emp.sex = 1,mhf.spleen,fhf.spleen) as h_spleen,
		if(emp.sex = 1,mhf.lung,fhf.lung) as h_lung,
		if(emp.sex = 1,mhf.kidney,fhf.kidney) as h_kidney,
		if(emp.sex = 1,mhf.note,fhf.note) as h_note,
		mhf.prostate as h_prostate,fhf.uterus as h_uterus,
		wc.id wc_id,wc.real_name wc_real_name,wc.department wc_department,
		wc.mobile wc_mobile,wc.position wc_position,wc.note wc_note,
		et.id et_id,et.task_id et_task_id,et.task_name et_task_name,et.note et_note,
		t.id t_id,t.title t_title,t.context t_context,t.note t_note
		from t_employee emp 
		left join t_male_health_form mhf on mhf.emp_id = emp.id
		left join t_female_health_form fhf on fhf.emp_id = emp.id
		left join t_work_card wc on emp.id = wc.emp_id
		left join t_employee_task et on emp.id = et.emp_id
		left join t_task t on t.id = et.task_id
		where emp.id = 5;
