 DROP TABLE IF EXISTS `vehicle_state`;
create table vehicle_state(
 id  varchar(40) PRIMARY KEY ,
 identifier varchar(40),
 name varchar(40),
 description varchar(200) DEFAULT NULL
 );

