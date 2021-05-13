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
@Table(name = "vehicle_state")
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


    @Column(name = "vehicle_state_id")
    private VehicleStateJpaEntity vehicleState; // 备注

    @Column(name = "vehicle_type_id")
    private VehicleTypeJpaEntity vehicleType; // 备注

}
