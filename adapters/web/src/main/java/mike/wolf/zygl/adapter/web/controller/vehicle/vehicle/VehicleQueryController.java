package mike.wolf.zygl.adapter.web.controller.vehicle.vehicle;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.web.service.VehicleFacade;
import mike.wolf.zygl.api.application.model.VehicleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@RequestMapping("/vehicleUseTypes")
@RequiredArgsConstructor
@CrossOrigin
public class VehicleQueryController {
    private final VehicleFacade vehicleFacade;

//    @GetMapping()
//    public CompletableFuture<ResponseEntity<List<VehicleDTO>>> getAllVehicleStates() {
//        log.info("REST getAllVehicleStates VehicleStateDTO");
//        return vehicleFacade.findAllVehicles();
//    }

//    @GetMapping(value = "/{id}")
//    public CompletableFuture<ResponseEntity<VehicleDTO>> findById(@PathVariable("id") String id) {
//        log.info("REST /vehicles/{id} : {}", id);
//        return vehicleFacade.findById(id);
//    }

//    @GetMapping(value = "/existsByName/{name}")
//    public CompletableFuture<Boolean> existsByName(@PathVariable("name") String name) {
//        log.info("REST /vehicleStates/existsByName/ : {}", name);
//        return vehicleFacade.existsByName(name);
//    }

}
