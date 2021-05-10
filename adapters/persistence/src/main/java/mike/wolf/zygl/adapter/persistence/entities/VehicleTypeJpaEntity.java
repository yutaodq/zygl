package mike.wolf.zygl.adapter.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class VehicleTypeJpaEntity {
    @Id
    private String id;

    @Column(name = "name")
    private String name;  //状态名称

    @Column(name = "description")
    private String description; // 备注

}
