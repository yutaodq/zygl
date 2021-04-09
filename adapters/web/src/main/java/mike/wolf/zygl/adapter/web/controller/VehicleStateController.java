package mike.wolf.zygl.adapter.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.web.model.FormVehicleStateDTO;
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

@WebAdapter

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
public class VehicleStateController {
    private final VehicleStateQueryUseCase getVehicleStateUseCase ;
    private final VehicleStateCreateUseCase createVehicleStateUseCase ;

    @GetMapping(value = "/helloworld")
    public String helloWorld(){
        log.info("REST request to get all VehicleStateDTO");
        return "Hello, welcome to COLA world!";
    }

//    @GetMapping(value = "/vehicleState")
//    public List<VehicleStateDTO>  getAllVehicleStates() {
//        log.info("REST request to get all VehicleStateDTO");
//        return getVehicleStateUseCase.findAll();
//    }

    @GetMapping(value = "/vehicleStates")
    public ResponseEntity<?> getAllVehicleStates() {
        log.info("REST request to get all VehicleStateDTO");
        return ResponseEntity.ok(getVehicleStateUseCase.findAll());
    }

//    public List<VehicleStateDTO>  getAllVehicleStates() {
//        log.info("REST request to get all VehicleStateDTO");
//        return getVehicleStateUseCase.findAll();
//    }

    @GetMapping(value = "/vehicleStates/{id}")
    public ResponseEntity<?>  getVehicleState(@PathVariable("id") String id) {
        log.debug("REST request to get VehicleStateDTO : {}", id);
        return ResponseEntity.ok(getVehicleStateUseCase.findById(id));
    }

    @GetMapping(value = "/vehicleStates/existsByName/{name}")
    public boolean  existsByName(@PathVariable("name") String name) {
        log.debug("REST request to get VehicleState name : {}", name);
        return getVehicleStateUseCase.existsByName(name);
    }

    @PostMapping("/vehicleStates")
    public void createVehicleState(@Valid @RequestBody FormVehicleStateDTO vehicleState) throws URISyntaxException {

        CreateVehicleStateCommand command = new CreateVehicleStateCommand(
                vehicleState.getIdentifier(),
                vehicleState.getName(),
                vehicleState.getName()
        ) ;
        createVehicleStateUseCase.create(command);
    }

}
