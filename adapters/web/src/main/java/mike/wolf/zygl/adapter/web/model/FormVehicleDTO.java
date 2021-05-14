package mike.wolf.zygl.adapter.web.model;

import lombok.Data;

@Data
public class FormVehicleDTO {
    private String id;
    private String name;
    private String pz;
    private String nbpz;
    private String vehicleTypeId;
    private String vehicleStateId;
    private String description;
    private String updateType;

}
