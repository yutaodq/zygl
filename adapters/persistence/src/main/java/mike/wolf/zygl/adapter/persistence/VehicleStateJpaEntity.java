package mike.wolf.zygl.adapter.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.common.persistence.AbstractEntity;
import mike.wolf.zygl.common.persistence.Identifiable;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "vehicle_state")
@Data
@AllArgsConstructor
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

    public VehicleStateJpaEntity() {
        log.info("新建：VehicleStateJpaEntity");
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof VehicleStateJpaEntity)) return false;
//        AbstractEntity that = (VehicleStateJpaEntity) o;
//        return Objects.equals(getId(), that.getId());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId());
//    }
}
