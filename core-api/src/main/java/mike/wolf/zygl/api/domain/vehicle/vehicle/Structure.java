package mike.wolf.zygl.api.domain.vehicle.vehicle;

import lombok.Builder;
import lombok.Value;

@Builder()
@Value
public class Structure {
    private String id;

    private Integer cc;  //车长

    private Integer ck;  //车宽

    private Integer cg;  //车高

    private Integer zj;  //轴距

    private Integer qlj;  //前轮距

    private Integer hlj;  //后轮距

    private String qdxs;  //驱动形式

    private String fxpwz;  //方向盘位置

    private String bsqxs;  //变数器形式

    private String description; // 备注

}
