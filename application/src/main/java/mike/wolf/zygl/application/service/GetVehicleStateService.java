package mike.wolf.zygl.application.service;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.application.model.VehicleStateDTO;
import mike.wolf.zygl.application.port.in.GetVehicleStateUseCase;
import mike.wolf.zygl.application.port.out.VehicleStateQueryAllPort;
import mike.wolf.zygl.common.UseCase;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetVehicleStateService implements GetVehicleStateUseCase {
    private final VehicleStateQueryAllPort vehicleStateQueryAllPort;

//    public GetVehicleStateService(VehicleStateQueryAllPort vehicleStateQueryAllPort) {
//        this.vehicleStateQueryAllPort = vehicleStateQueryAllPort;
//    }

    @Override
    public  List<VehicleStateDTO> findAll() {
        return this.findAll(true);

    }
    private List<VehicleStateDTO> findAll(boolean removeUnavailableProducts) {

        List<VehicleStateDTO> vehicleStates = vehicleStateQueryAllPort.findAllVehicleStates();
return vehicleStates;
    }

}

