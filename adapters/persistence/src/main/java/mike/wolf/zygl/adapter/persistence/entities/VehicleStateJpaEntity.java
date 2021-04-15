package mike.wolf.zygl.adapter.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder(toBuilder = true)

@Slf4j
public class VehicleStateJpaEntity {

    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid")
//    @Column(columnDefinition = "CHAR(36)", nullable = false)
    private String id;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "name")
    private String name;  //状态名称

    @Column(name = "description")
    private String description; // 备注

//    https://github.com/wfercosta/camunda-spring-boot-js-react-microservices-aws-example
//    @CreatedDate
//    @EqualsAndHashCode.Exclude
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    private LocalDateTime createdAt;

    //    public VehicleStateJpaEntity() {
//        log.info("新建：VehicleStateJpaEntity");
//    }

}
