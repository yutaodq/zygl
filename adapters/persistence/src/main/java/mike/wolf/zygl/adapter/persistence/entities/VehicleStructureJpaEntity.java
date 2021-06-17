package mike.wolf.zygl.adapter.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_structure")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true) //如果加true，可以修改这个对象属性值

@Slf4j
public class VehicleStructureJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "cc_nb")
    private Number cc;  //车长

    @Column(name = "ck_nb")
    private Number ck;  //车宽

    @Column(name = "cg_nb")
    private Number cg;  //车高

    @Column(name = "zj_nb")
    private Number zj;  //轴距

    @Column(name = "qlj_nb")
    private Number qlj;  //前轮距

    @Column(name = "hlj_nb")
    private Number hlj;  //后轮距

    @Column(name = "qdxs_tx")
    private String qdxs;  //驱动形式

    @Column(name = "fxpwz_tx")
    private String fxpwz;  //方向盘位置

    @Column(name = "bsqxs_tx")
    private String bsqxs;  //变数器形式

    @Column(name = "description_tx")
    private String description; // 备注
}
