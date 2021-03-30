package mike.wolf.zygl.adapter.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_state")
@Data
@AllArgsConstructor
@NoArgsConstructor

@Slf4j
public class VehicleStateJpaEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(36)", nullable = false)
    private String id;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "name")
    private String name;  //状态名称

    @Column(name = "description")
    private String description; // 备注

//    public VehicleStateJpaEntity() {
//        log.info("新建：VehicleStateJpaEntity");
//    }

}
