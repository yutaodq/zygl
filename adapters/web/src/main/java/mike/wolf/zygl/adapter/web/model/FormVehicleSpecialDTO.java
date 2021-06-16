package mike.wolf.zygl.adapter.web.model;

import lombok.Data;

@Data
public class FormVehicleSpecialDTO {
    private String id;
    private Number zdqzl;  //最大起重量
    private Number gjbj;  //工作半径
    private Number zb;  //主笔
    private Number zbc;  //主臂长
    private Number fbc;  //副臂长
    private String fdjxh;  //发动机型号
    private Number edgl;  //额定功率
    private Number zdnj;  //最大扭矩
    private Number qdxs;  //最高转速
    private String rylx;  //燃油类型
    private Number pjyh;  //平均油耗
    private String glxh;  //锅炉型号
    private String ysjxh;  //压缩机型号
    private String bxh;  //泵型号
    private String csyq;  //测试仪器
    private Number dr;  //斗容
    private String bsqxs;  //变数器形式
    private String description; // 备注
}
