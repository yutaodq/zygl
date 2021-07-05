package mike.wolf.zygl.api.application.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode(of = {"id"})
@Data
//@Builder(toBuilder = true) //如果加true，可以修改这个对象属性值

public class VehicleDTO {
    private String id;
    private String name;  //车辆名称
    private String ggxh;  //规格型号
    private String pz;  //牌照号
    private String nbpz;  //内部牌照号
    private String sccj;  //生产厂家
    private Date ccrq;  //出厂日期
    private Date tcrq;  //投产日期
    private BigDecimal yz;  //车辆原值
    private String csys;  //车身颜色
    private String fdjxh;  //发动机型号
    private String fdjbh;  //发动机编号
    private String dpxh;  //底盘型号
    private String dpbh;  //底盘编号
    private String description; // 备注

    /*
    VehicleStructureJpaEntity
     */
//    private String stId;
    private Integer stCc;  //车长
    private Integer stCk;  //车宽
    private Integer stCg;  //车高
    private Integer stZj;  //轴距
    private Integer stQlj;  //前轮距
    private Integer stHlj;  //后轮距
    private String stQdxs;  //驱动形式
    private String stFxpwz;  //方向盘位置
    private String stBsqxs;  //变数器形式
//    private String stDescription; // 备注
    /*
    VehicleParameterJpaEntity
     */
//    private String paId;

    private Integer paZczbzl;  //整车装备质量
    private Integer paZdzzzl;  //最大装载质量
    private String paRylx;  //燃油类型
    private Integer paPjyh;  //平均油耗
    private Integer paEdgl;  //额定功率
    private Integer paZdnj;  //最大扭矩
    private Integer paZxzwbj;  //最小转弯半径
    private Integer paZgcs;  //最高车速
//    private String paDescription; // 备注

    /*
    VehicleSpecial
     */
//    private String spId;
    private Integer spZdqzl;  //最大起重量
    private Integer spGjbj;  //工作半径
    private Integer spZb;  //主笔
    private Integer spZbc;  //主臂长
    private Integer spFbc;  //副臂长
    private String spFdjxh;  //发动机型号
    private Integer spEdgl;  //额定功率
    private Integer spZdnj;  //最大扭矩
    private Integer spZgzs;  //最高转速
    private String spRylx;  //燃油类型
    private Integer spPjyh;  //平均油耗
    private String spGlxh;  //锅炉型号
    private String spYsjxh;  //压缩机型号
    private String spBxh;  //泵型号
    private String spCsyq;  //测试仪器
    private Integer spDr;  //斗容
    private String spBsqxs;  //变数器形式
//    private String spDescription; // 备注

    /*
    VehicleType
     */
//    private String typeId;
    private String typeName;

    /*
    VehicleState
     */
//    private String stateId;
    private String stateName;

}
