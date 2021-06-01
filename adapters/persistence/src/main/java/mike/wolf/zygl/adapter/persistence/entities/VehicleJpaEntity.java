package mike.wolf.zygl.adapter.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "vehicle")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true) //如果加true，可以修改这个对象属性值

@Slf4j
public class VehicleJpaEntity {
    @Id
    private String id;

    @Column(name = "name_tx")
    private String name;  //车辆名称

    @Column(name = "ggxh_tx")
    private String ggxh;  //规格型号

    @Column(name = "pz_tx")
    private String pz;  //牌照号

    @Column(name = "nbpz_tx")
    private String nbpz;  //内部牌照号

    @Column(name = "sccj_tx")
    private String sccj;  //生产厂家

    @Column(name = "ccrq_dt")
    private Date ccrq;  //出厂日期

    @Column(name = "tcrq_dt")
    private Date tcrq;  //投产日期

//    @Column(name = "yz_nb", columnDefinition = "Float (10,2)")
//    private Float  yz;  //车辆原值
//private BigDecimal  yz;  //车辆原值
    @Column(name = "yz_nb", precision = 10, scale = 2)
    private Float  yz;  //车辆原值

    @Column(name = "csys_tx")
    private String csys;  //车身颜色

    @Column(name = "fdjxh_tx")
    private String fdjxh;  //发动机型号

    @Column(name = "fdjbh_tx")
    private String fdjbh;  //发动机编号

    @Column(name = "dpxh_tx")
    private String dpxh;  //底盘型号

    @Column(name = "dpbh_tx")
    private String dpbh;  //底盘编号

    @Column(name = "description_tx")
    private String description; // 备注

    @ManyToOne(targetEntity=VehicleStateJpaEntity.class)
    @JoinColumn(name = "vehicle_state_id",referencedColumnName="id")
    private VehicleStateJpaEntity vehicleState; // 备注

    @ManyToOne(targetEntity=VehicleTypeJpaEntity.class)
    @JoinColumn(name = "vehicle_type_id",referencedColumnName="id")
    private VehicleTypeJpaEntity vehicleType; // 备注

    @ManyToOne(targetEntity=VehicleStructureJpaEntity.class)
    @JoinColumn(name = "vehicle_structure_id",referencedColumnName="id")
    private VehicleStructureJpaEntity vehicleStructure; // 备注

    @ManyToOne(targetEntity=VehicleParameterJpaEntity.class)
    @JoinColumn(name = "vehicle_parametere_id",referencedColumnName="id")
    private VehicleParameterJpaEntity vehicleParameter; // 备注

    @ManyToOne(targetEntity=VehicleSpecialJpaEntity.class)
    @JoinColumn(name = "vehicle_special_id",referencedColumnName="id")
    private VehicleSpecialJpaEntity vehicleSpecial; // 备注

}
