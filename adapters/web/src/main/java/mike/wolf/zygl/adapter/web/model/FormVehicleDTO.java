package mike.wolf.zygl.adapter.web.model;

import lombok.Data;

import java.util.Date;

@Data
public class FormVehicleDTO {
    private String id;
    private String name;  //车辆名称
    private String ggxh;  //规格型号
    private String pz;  //牌照号
    private String nbpz;  //内部牌照号
    private String sccj;  //生产厂家
    private Date ccrq;  //出厂日期
    private Date tcrq;  //投产日期
    private Float yz;  //车辆原值
    private String csys;  //车身颜色
    private String fdjxh;  //发动机型号
    private String fdjbh;  //发动机编号
    private String dpxh;  //底盘型号
    private String dpbh;  //底盘编号
    private String description; // 备注
    private FormVehicleStructureDTO structure;
    private FormVehicleParameterDTO parameter;
    private FormVehicleSpecialDTO special;

};
