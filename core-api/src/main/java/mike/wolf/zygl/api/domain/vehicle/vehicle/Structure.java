package mike.wolf.zygl.api.domain.vehicle.vehicle;

import lombok.Builder;
import lombok.Value;

@Builder()
@Value
public class Structure {
    private String id;

    private Number cc;  //车长

    private Number ck;  //车宽

    private Number cg;  //车高

    private Number zj;  //轴距

    private Number qlj;  //前轮距

    private Number hlj;  //后轮距

    private String qdxs;  //驱动形式

    private String fxpwz;  //方向盘位置

    private String bsqxs;  //变数器形式

    private String description; // 备注

}
