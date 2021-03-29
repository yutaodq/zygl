package mike.wolf.zygl.application.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class VehicleStateDTO {
    private Long id;

    private String name;

    private String description;

}
