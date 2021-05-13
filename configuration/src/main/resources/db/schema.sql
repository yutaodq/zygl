 DROP TABLE IF EXISTS `vehicle_state`;
create table vehicle_state(
 id  varchar(40) PRIMARY KEY ,
 name varchar(40),
 description varchar(200) DEFAULT NULL
 );

 DROP TABLE IF EXISTS `vehicle_type`;
create table vehicle_type(
 id  varchar(40) PRIMARY KEY ,
 name varchar(40),
 description varchar(200) DEFAULT NULL
 );

 DROP TABLE IF EXISTS `vehicle`;
create table vehicle(
 id  varchar(40) PRIMARY KEY ,
 name varchar(40),
 pz varchar(40),
  nbpz varchar(40),
vehicleTypeId varchar(40),
vehicleStateId varchar(40),
 description varchar(200) DEFAULT NULL
 );
