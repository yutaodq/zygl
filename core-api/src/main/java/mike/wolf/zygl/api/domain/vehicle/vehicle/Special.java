package mike.wolf.zygl.api.domain.vehicle.vehicle;

import lombok.Builder;
import lombok.Value;

@Builder()
@Value
public class Special {
    private String id;

    private int zdqzl;  //最大起重量

    private int gjbj;  //工作半径

    private int zb;  //主笔

    private int zbc;  //主臂长

    private int fbc;  //副臂长

    private String fdjxh;  //发动机型号

    private int edgl;  //额定功率

    private int zdnj;  //最大扭矩

    private int zgzs;  //最高转速

    private String rylx;  //燃油类型

    private int pjyh;  //平均油耗

    private String glxh;  //锅炉型号

    private String ysjxh;  //压缩机型号

    private String bxh;  //泵型号

    private String csyq;  //测试仪器

    private int dr;  //斗容

    private String bsqxs;  //变数器形式

    private String description; // 备注
}
