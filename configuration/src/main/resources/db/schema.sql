 DROP TABLE IF EXISTS `vehicle_state`;
create table vehicle_state(
 id  varchar(40) PRIMARY KEY ,
 identifier varchar(40),
 name varchar(40),
 description varchar(200) DEFAULT NULL
 );

delete from vehicle_state;
insert into vehicle_state values('1','1','在用', '车辆正常运行');
insert into vehicle_state values('2','2','停用', '车辆停止运行');
insert into vehicle_state values('3','3','待修', '车辆维修');
