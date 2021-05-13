package mike.wolf.zygl.api.application.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class VehicleDTO {
    private String id;
    private String name;
    private String pz;
    private String nbpz;
    private String useType;
    private String useState;

}
