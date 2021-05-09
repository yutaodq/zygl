package mike.wolf.zygl.api.application.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class VehicleTypeDTO {
    private String id;

    private String name;

    private String description;

}
