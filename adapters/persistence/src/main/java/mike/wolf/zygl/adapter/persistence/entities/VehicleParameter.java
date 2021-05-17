package mike.wolf.zygl.adapter.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_parameter")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true) //如果加true，可以修改这个对象属性值

@Slf4j

public class VehicleParameter {
    @Id
    private String id;

    @Column(name = "zczbzl_nb")
    private String zczbzl;  //整车装备质量

    @Column(name = "zdzzzl_nb")
    private String zdzzzl;  //最大装载质量

    @Column(name = "cc_nb")
    private String cc;  //车长

    @Column(name = "ck_nb")
    private String ck;  //车宽

    @Column(name = "cg_nb")
    private String cg;  //车高

    @Column(name = "zj_nb")
    private String zj;  //轴距

    @Column(name = "qlj_nb")
    private String qlj;  //前轮距

    @Column(name = "hlj_nb")
    private Number hlj;  //后轮距

    @Column(name = "qdxs_tx")
    private Number qdxs;  //驱动形式

    @Column(name = "rylx_tx")
    private String rylx;  //燃油类型

    @Column(name = "pjyh_nb")
    private String pjyh;  //平均油耗

    @Column(name = "edgl_nb")
    private String edgl;  //额定功率

    @Column(name = "zdnj_nb")
    private String zdnj;  //最大扭矩

    @Column(name = "fxpwz_tx")
    private String fxpwz;  //方向盘位置

    @Column(name = "zxzwbj_nb")
    private String zxzwbj;  //最小转弯半径

    @Column(name = "zgcs_nb")
    private String zgcs;  //最高车速

    @Column(name = "bsqxs_tx")
    private String bsqxs;  //变数器形式

    @Column(name = "description_tx")
    private String description; // 备注
}
