package mike.wolf.zygl.api.application.model;

import lombok.*;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode(of = {"id"})
@Data
public class VehicleDTO {
    private String id;
    private String name;
    private String pz;
    private String nbpz;
    private String typeName;
    private String stateName;

}
