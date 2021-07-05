package mike.wolf.zygl.api.domain.vehicle.vehicle;

import lombok.Builder;
import lombok.Value;

@Builder()
@Value
public class Parameter {
    private String id;
    private Integer zczbzl;  //整车装备质量

    private Integer zdzzzl;  //最大装载质量

    private String rylx;  //燃油类型

    private Integer pjyh;  //平均油耗

    private Integer edgl;  //额定功率

    private Integer zdnj;  //最大扭矩

    private Integer zxzwbj;  //最小转弯半径

    private Integer zgcs;  //最高车速

    private String description; // 备注

}
