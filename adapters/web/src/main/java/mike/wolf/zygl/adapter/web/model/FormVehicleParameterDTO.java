package mike.wolf.zygl.adapter.web.model;

import lombok.Data;

@Data
public class FormVehicleParameterDTO {
    private String id;
    private int zczbzl;  //整车装备质量
    private int zdzzzl;  //最大装载质量
    private String rylx;  //燃油类型
    private int pjyh;  //平均油耗
    private int edgl;  //额定功率
    private int zdnj;  //最大扭矩
    private int zxzwbj;  //最小转弯半径
    private int zgcs;  //最高车速
    private String description; // 备注
}
