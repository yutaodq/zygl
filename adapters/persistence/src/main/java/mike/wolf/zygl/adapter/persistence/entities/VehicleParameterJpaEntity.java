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

public class VehicleParameterJpaEntity {
    @Id
    private String id;

    @Column(name = "zczbzl_nb")
    private Number zczbzl;  //整车装备质量

    @Column(name = "zdzzzl_nb")
    private Number zdzzzl;  //最大装载质量

    @Column(name = "rylx_tx")
    private String rylx;  //燃油类型

    @Column(name = "pjyh_nb")
    private Number pjyh;  //平均油耗

    @Column(name = "edgl_nb")
    private Number edgl;  //额定功率

    @Column(name = "zdnj_nb")
    private Number zdnj;  //最大扭矩

    @Column(name = "zxzwbj_nb")
    private Number zxzwbj;  //最小转弯半径

    @Column(name = "zgcs_nb")
    private Number zgcs;  //最高车速

    @Column(name = "description_tx")
    private String description; // 备注
}
