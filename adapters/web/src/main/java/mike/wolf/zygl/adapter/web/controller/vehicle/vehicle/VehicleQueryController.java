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
@RequestMapping("/vehicles")
@RequiredArgsConstructor
@CrossOrigin
public class VehicleQueryController {
    private final VehicleFacade vehicleFacade;

    @GetMapping()
    public CompletableFuture<ResponseEntity<List<VehicleDTO>>> getAllVehicles() {
        log.info("REST getAllVehicleStates VehicleStateDTO");
        return vehicleFacade.findAll();
    }

    @GetMapping(value = "/{id}")
    public CompletableFuture<ResponseEntity<VehicleDTO>> findById(@PathVariable("id") String id) {
        log.info("REST /vehicles/{id} : {}", id);
        return vehicleFacade.findById(id);
    }

    @GetMapping(value = "/existsByPz/{pz}")
        public CompletableFuture<Boolean> existsByPz(@PathVariable("pz") String pz) {
        log.info("REST /vehicleStates/existsByName/ : {}", pz);
        return vehicleFacade.existsByPz(pz);
    }
    @GetMapping(value = "/existsByNbpz/{nbpz}")
    public CompletableFuture<Boolean> existsByNbpz(@PathVariable("nbpz") String nbpz) {
        log.info("REST /vehicleStates/existsByName/ : {}", nbpz);
        return vehicleFacade.existsByNbpz(nbpz);
    }

}
