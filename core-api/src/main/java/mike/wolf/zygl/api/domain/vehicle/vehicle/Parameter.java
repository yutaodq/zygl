package mike.wolf.zygl.api.domain.vehicle.vehicle;

import lombok.Builder;
import lombok.Value;

@Builder()
@Value
public class Parameter {
    private String id;
    private Number zczbzl;  //整车装备质量

    private Number zdzzzl;  //最大装载质量

    private String rylx;  //燃油类型

    private Number pjyh;  //平均油耗

    private Number edgl;  //额定功率

    private Number zdnj;  //最大扭矩

    private Number zxzwbj;  //最小转弯半径

    private Number zgcs;  //最高车速

    private String description; // 备注

}
