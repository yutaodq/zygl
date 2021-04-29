package mike.wolf.zygl.adapter.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.web.model.FormVehicleStateDTO;
import mike.wolf.zygl.adapter.web.service.VehicleStateFacade;
import mike.wolf.zygl.application.port.in.VehicleStateCreateUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

@RestController
@Slf4j
@RequestMapping("/api/vehicleUseStates")
@RequiredArgsConstructor
@CrossOrigin
public class VehicleStateCommandController {
//    private final VehicleStateFacade vehicleStateFacade;
//
//    @PostMapping("/vehicleUseStates")
//    public ResponseEntity<?> createVehicleState(
//            @Valid @RequestBody FormVehicleStateDTO formVehicleStateDTO)
//            throws URISyntaxException {
//
//        log.info("REST createVehicleState : {}", formVehicleStateDTO.getName());
//        return vehicleStateFacade.createVehicleState(formVehicleStateDTO);
//    }

}
