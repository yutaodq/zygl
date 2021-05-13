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
@Table(name = "organization_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true) //如果加true，可以修改这个对象属性值

@Slf4j
public class OrganizationTypeJpaEntity {
    @Id
    private String id;

    @Column(name = "name")
    private String name;  //状态名称

    @Column(name = "description")
    private String description; // 备注

}
