package mike.wolf.zygl.adapter.web.controller.vehicle.type;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.web.service.VehicleTypeFacade;
import mike.wolf.zygl.api.application.model.VehicleStateDTO;
import mike.wolf.zygl.api.application.model.VehicleTypeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@RequestMapping("/vehicleUseTypes")
@RequiredArgsConstructor
@CrossOrigin
public class VehicleTypeQueryController {
    private final VehicleTypeFacade vehicleTypeFacade;
    @GetMapping()
    public CompletableFuture<ResponseEntity<List<VehicleTypeDTO>>> getAllVehicleStates() {
        log.info("REST getAllVehicleStates VehicleStateDTO");
        return vehicleTypeFacade.findAllVehicleTypes();
    }

}
