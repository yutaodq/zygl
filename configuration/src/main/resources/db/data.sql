delete from vehicle_state;
insert into vehicle_state values('1','在用', '车辆正常运行');
insert into vehicle_state values('2','停用', '车辆停止运行');
insert into vehicle_state values('3','待修', '车辆维修');

delete from vehicle_type;
insert into vehicle_type values('1','锅炉车', '锅炉车主要是用来');
insert into vehicle_type values('2','水泥车', '水泥车是打压用的');
insert into vehicle_type values('3','污水罐车', '水');

delete from vehicle;
insert into vehicle values('1','车辆基础信息', 'E123','Z123', '1','1','在用锅炉车');
insert into vehicle values('2','车辆基础信息222', 'E456','Z456', '2','2','停用水泥车');
