package mike.wolf.zygl.adapter.web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.web.model.FormVehicleStateDTO;
import mike.wolf.zygl.application.port.in.VehicleStateCreateUseCase;
import mike.wolf.zygl.application.port.in.VehicleStateCreateUseCase.CreateVehicleStateCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.net.URISyntaxException;

@Slf4j
@RequiredArgsConstructor
public class VehicleStateFacade {
    private final VehicleStateCreateUseCase createVehicleStateUseCase;

    public ResponseEntity<?> createVehicleState( FormVehicleStateDTO vehicleState)
            throws URISyntaxException {

        log.info("VehicleStateFacade REST createVehicleState : {}", vehicleState.getName());
        String identifier = vehicleState.getIdentifier();

        CreateVehicleStateCommand command = new CreateVehicleStateCommand(
                identifier,
                vehicleState.getName(),
                vehicleState.getDescription()
        );

        createVehicleStateUseCase.create(command);

        return ResponseEntity.ok(vehicleState);
    }

}
