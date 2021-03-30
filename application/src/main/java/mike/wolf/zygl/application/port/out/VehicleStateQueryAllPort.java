package mike.wolf.zygl.application.port.out;

import mike.wolf.zygl.application.model.VehicleStateDTO;

import java.util.List;

public interface VehicleStateQueryAllPort extends ManagementTransaction{
    List<VehicleStateDTO> findAllVehicleStates();

}
