DROP TABLE IF EXISTS `vehicle_state`;
create table vehicle_state
(
    id          varchar(40) PRIMARY KEY,
    name        varchar(40),
    description varchar(200) DEFAULT NULL
);

DROP TABLE IF EXISTS `vehicle_type`;
create table vehicle_type
(
    id          varchar(40) PRIMARY KEY,
    name        varchar(40),
    description varchar(200) DEFAULT NULL
);

DROP TABLE IF EXISTS `vehicle_structure`;
create table vehicle_structure
(
    id             varchar(40) PRIMARY KEY,
    cc_nb          number(4),
    ck_nb          number(4),
    cg_nb          number(4),
    zj_nb          number(4),
    qlj_nb         number(4),
    hlj_nb         number(4),
    qdxs_tx        varchar(40),
    fxpwz_tx       varchar(40),
    bsqxs_tx       varchar(40),
    description_tx varchar(500)

);

DROP TABLE IF EXISTS `vehicle_parameter`;
create table vehicle_parameter
(
    id             varchar(40) PRIMARY KEY,
    zczbzl_nb      number(4),
    zdzzzl_nb      number(4),

    rylx_tx        varchar(40),

    pjyh_nb        number(4),
    edgl_nb        number(4),
    zdnj_nb        number(4),
    zxzwbj_nb      number(4),
    zgcs_nb        number(4),
    description_tx varchar(500)

);

DROP TABLE IF EXISTS `vehicle_special`;
create table vehicle_special
(
    id             varchar(40) PRIMARY KEY,
    zdqzl_nb       number(4),
    gjbj_nb        number(4),
    zb_nb          number(4),
    zbc_nb         number(4),
    fbc_nb         number(4),
    fdjxh_tx       varchar(40),
    edgl_nb        number(4),
    zdnj_nb        number(4),
    zgzs_nb        number(4),
    rylx_tx        varchar(40),
    pjyh_nb        number(4),
    glxh_tx        varchar(40),
    ysjxh_tx       varchar(40),
    bxh_tx         varchar(40),
    csyq_tx        varchar(40),
    dr_nbb         number(4),
    bsqxs_tx       varchar(40),

    description_tx varchar(500)


);

DROP TABLE IF EXISTS `vehicle`;
create table vehicle
(
    id                    varchar(40) PRIMARY KEY,
    name_tx               varchar(40),
    ggxh_tx               varchar(40),
    pz_tx                 varchar(40),
    nbpz_tx               varchar(40),
    sccj_tx               varchar(40),

    ccrq_dt               date,
    tcrq_dt               date,
    yz_nb                 number(10,2),
    csys_tx               varchar(40),
    fdjxh_tx              varchar(40),
    fdjbh_tx              varchar(40),
    dpxh_tx               varchar(40),
    dpbh_tx               varchar(40),
    description_tx        varchar(500),
    vehicle_state_id      varchar(40),
    vehicle_type_id       varchar(40),
    vehicle_structure_id  varchar(40),
    vehicle_parametere_id varchar(40),
    vehicle_special_id    varchar(40),
    constraint type_vehicle_fk foreign key (vehicle_type_id) REFERENCES vehicle_type (id),
    constraint state_vehicle_fk foreign key (vehicle_state_id) REFERENCES vehicle_state (id),
    constraint structure_vehicle_fk foreign key (vehicle_structure_id) REFERENCES vehicle_structure (id),
    constraint parametere_vehicle_fk foreign key (vehicle_parametere_id) REFERENCES vehicle_parameter (id),
    constraint type_special_fk foreign key (vehicle_special_id) REFERENCES vehicle_special (id)

);

