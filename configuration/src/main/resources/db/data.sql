delete from vehicle_state;
insert into vehicle_state values('1','在用', '车辆正常运行');
insert into vehicle_state values('2','停用', '车辆停止运行');
insert into vehicle_state values('3','待修', '车辆维修');

delete from vehicle_type;
insert into vehicle_type values('1','锅炉车', '锅炉车主要是用来');
insert into vehicle_type values('2','水泥车', '水泥车是打压用的');
insert into vehicle_type values('3','污水罐车', '水');

delete from vehicle_parameter;
insert into vehicle_parameter(id, rylx_tx) values('1','汽油');
insert into vehicle_parameter (id, rylx_tx) values('2','柴油');

delete from vehicle_special;
insert into vehicle_special(id, fdjxh_tx) values('1','发动机型号1');
insert into vehicle_special (id, fdjxh_tx) values('2','发动机型号2');

delete from vehicle_structure;
insert into vehicle_structure(id, fxpwz_tx) values('1','方向盘位置-1');
insert into vehicle_structure (id, fxpwz_tx) values('2','方向盘位置-12');

delete from vehicle;
insert into vehicle(id, name_tx, ggxh_tx, vehicle_state_id, vehicle_type_id, vehicle_structure_id, vehicle_parametere_id, vehicle_special_id) values('1','车辆基础信息', 'E123','1', '1','1','1','1');
insert into vehicle(id, name_tx, ggxh_tx, vehicle_state_id, vehicle_type_id, vehicle_structure_id, vehicle_parametere_id, vehicle_special_id) values('2','车辆基础信息2', 'E123','2', '2','2','2','2');
