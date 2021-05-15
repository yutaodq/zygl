package mike.wolf.zygl.adapter.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

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

    @Column(name = "name")
    private String name;  //状态名称

    @Column(name = "pz")
    private String pz;  //状态名称

    @Column(name = "nbpz")
    private String nbpz;  //状态名称

    @Column(name = "description")
    private String description; // 备注

    @ManyToOne(targetEntity=VehicleStateJpaEntity.class)
    @JoinColumn(name = "vehicle_state_id",referencedColumnName="id")
    private VehicleStateJpaEntity vehicleState; // 备注

    @ManyToOne(targetEntity=VehicleTypeJpaEntity.class)
    @JoinColumn(name = "vehicle_type_id",referencedColumnName="id")
    private VehicleTypeJpaEntity vehicleType; // 备注

}
