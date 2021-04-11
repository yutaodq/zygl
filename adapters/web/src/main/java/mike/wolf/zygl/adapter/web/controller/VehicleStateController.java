package mike.wolf.zygl.adapter.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.web.model.FormVehicleStateDTO;
import mike.wolf.zygl.application.model.VehicleStateDTO;
import mike.wolf.zygl.application.port.in.VehicleStateCreateUseCase;
import mike.wolf.zygl.application.port.in.VehicleStateCreateUseCase.CreateVehicleStateCommand;
import mike.wolf.zygl.application.port.in.VehicleStateQueryUseCase;
import mike.wolf.zygl.common.WebAdapter;
import mike.wolf.zygl.domain.VehicleState;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URISyntaxException;
import java.util.List;

@WebAdapter

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class VehicleStateController {
    private final VehicleStateQueryUseCase getVehicleStateUseCase ;
    private final VehicleStateCreateUseCase createVehicleStateUseCase ;

    @GetMapping(value = "/helloworld")
    public String helloWorld(){
        log.info("REST request to get all VehicleStateDTO");
        return "Hello, welcome to COLA world!";
    }

    @GetMapping(value = "/vehicleStates")
    public ResponseEntity<?> getAllVehicleStates() {
        log.info("REST getAllVehicleStates VehicleStateDTO");
        return ResponseEntity.ok(getVehicleStateUseCase.findAll());
    }

//    public List<VehicleStateDTO>  getAllVehicleStates() {
//        log.info("REST request to get all VehicleStateDTO");
//        return getVehicleStateUseCase.findAll();
//    }

    @GetMapping(value = "/vehicleStates/{id}")
    public ResponseEntity<?>  getVehicleState(@PathVariable("id") String id) {
        log.debug("REST /vehicleStates/{id} : {}", id);
        return ResponseEntity.ok(getVehicleStateUseCase.findById(id));
    }

    @GetMapping(value = "/vehicleStates/existsByName/{name}")
    public boolean  existsByName(@PathVariable("name") String name) {
        log.debug("REST /vehicleStates/existsByName/ : {}", name);
        return getVehicleStateUseCase.existsByName(name);
    }

//    @GetMapping(value = "/vehicleStates/{name}")
//    public ResponseEntity<?>  findByName(@PathVariable("name") String name) {
//        log.info("REST /vehicleStates-------/findByName/ : {}", name);
//        return ResponseEntity.ok(getVehicleStateUseCase.findByName(name));
//    }
@GetMapping(value = "/vehicleStates/findByName/{name}")
public List<VehicleStateDTO> findByName(@PathVariable("name") String name) {
    log.info("REST /vehicleStates/findByName/ : {}", name);
    return getVehicleStateUseCase.findByName(name);
}

//    public List<VehicleStateDTO>  getAllVehicleStates() {
//        log.info("REST request to get all VehicleStateDTO");
//        return getVehicleStateUseCase.findAll();
//    }

@PostMapping("/vehicleStates")
public ResponseEntity<?> createVehicleState(@Valid @RequestBody FormVehicleStateDTO vehicleState) throws URISyntaxException {
    log.info("REST createVehicleState : {}", vehicleState.getName());

    CreateVehicleStateCommand command = new CreateVehicleStateCommand(
            vehicleState.getId(),
            vehicleState.getIdentifier(),
            vehicleState.getName(),
            vehicleState.getDescription()
    ) ;
    createVehicleStateUseCase.create(command);

    return ResponseEntity.ok(vehicleState);
}

}
