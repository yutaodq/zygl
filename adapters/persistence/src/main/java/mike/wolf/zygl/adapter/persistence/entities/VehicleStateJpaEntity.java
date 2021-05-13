package mike.wolf.zygl.adapter.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_state")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true) //如果加true，可以修改这个对象属性值

@Slf4j
public class VehicleStateJpaEntity {
    @Id
    private String id;

    @Column(name = "name", unique=true)
    private String name;  //状态名称

    @Column(name = "description")
    private String description; // 备注

}
