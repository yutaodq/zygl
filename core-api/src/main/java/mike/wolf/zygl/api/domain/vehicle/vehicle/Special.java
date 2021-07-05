package mike.wolf.zygl.api.domain.vehicle.vehicle;

import lombok.Builder;
import lombok.Value;

@Builder()
@Value
public class Special {
    private String id;

    private Integer zdqzl;  //最大起重量

    private Integer gjbj;  //工作半径

    private Integer zb;  //主笔

    private Integer zbc;  //主臂长

    private Integer fbc;  //副臂长

    private String fdjxh;  //发动机型号

    private Integer edgl;  //额定功率

    private Integer zdnj;  //最大扭矩

    private Integer zgzs;  //最高转速

    private String rylx;  //燃油类型

    private Integer pjyh;  //平均油耗

    private String glxh;  //锅炉型号

    private String ysjxh;  //压缩机型号

    private String bxh;  //泵型号

    private String csyq;  //测试仪器

    private Integer dr;  //斗容

    private String bsqxs;  //变数器形式

    private String description; // 备注
}
