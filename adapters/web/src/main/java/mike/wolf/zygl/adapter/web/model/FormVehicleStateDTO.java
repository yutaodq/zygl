package mike.wolf.zygl.adapter.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FormVehicleStateDTO {
    private String id;
    private String identifier;

    private String name;

    private String description;

}
