package mike.wolf.zygl.adapter.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.web.model.FormVehicleStateDTO;
import mike.wolf.zygl.adapter.web.service.VehicleStateFacade;
import mike.wolf.zygl.application.model.VehicleStateDTO;
import mike.wolf.zygl.application.port.in.VehicleStateCreateUseCase;
import mike.wolf.zygl.application.port.in.VehicleStateCreateUseCase.CreateVehicleStateCommand;
import mike.wolf.zygl.application.port.in.VehicleStateDeleteUseCase;
import mike.wolf.zygl.application.port.in.VehicleStateDeleteUseCase.DeleteVehicleStateCommand;
import mike.wolf.zygl.application.port.in.VehicleStateQueryUseCase;
import mike.wolf.zygl.application.port.in.VehicleStateUpdateUseCase;
import mike.wolf.zygl.application.port.in.VehicleStateUpdateUseCase.UpdateVehicleStateCommand;

import mike.wolf.zygl.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@WebAdapter

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class VehicleStateController {
    private final VehicleStateQueryUseCase getVehicleStateUseCase;
    private final VehicleStateCreateUseCase createVehicleStateUseCase;
    private final VehicleStateDeleteUseCase vehicleStateDeleteUseCase;
    private final VehicleStateUpdateUseCase vehicleStateUpdateUseCase;
    private final VehicleStateFacade vehicleStateFacade;

    @GetMapping(value = "/helloworld")
    public String helloWorld() {
        log.info("REST request to get all VehicleStateDTO");
        return "Hello, welcome to COLA world!";
    }

    //    @GetMapping(value = "/vehicleUseStates")
//    public ResponseEntity<?> getAllVehicleStates() {
//        log.info("REST getAllVehicleStates VehicleStateDTO");
//        return ResponseEntity.ok(getVehicleStateUseCase.findAll());
//    }
    @GetMapping(value = "/vehicleUseStates")
    public CompletableFuture<ResponseEntity<List<VehicleStateDTO>>> getAllVehicleStates() {
        log.info("REST getAllVehicleStates VehicleStateDTO");
        return vehicleStateFacade.findAllVehicleStates();
    }

//    public List<VehicleStateDTO>  getAllVehicleStates() {
//        log.info("REST request to get all VehicleStateDTO");
//        return getVehicleStateUseCase.findAll();
//    }


    @GetMapping(value = "/vehicleUseStates/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
        log.debug("REST /vehicleStates/{id} : {}", id);
        return vehicleStateFacade.findById(id));
    }

//    public ResponseEntity<?> getVehicleState(@PathVariable("id") String id) {
//        log.debug("REST /vehicleStates/{id} : {}", id);
//        return ResponseEntity.ok(getVehicleStateUseCase.findById(id));
//    }

    @GetMapping(value = "/vehicleUseStates/existsByName/{name}")
    public boolean existsByName(@PathVariable("name") String name) {
        log.info("REST /vehicleStates/existsByName/ : {}", name);
        return getVehicleStateUseCase.existsByName(name);
    }

    //    @GetMapping(value = "/vehicleStates/{name}")
//    public ResponseEntity<?>  findByName(@PathVariable("name") String name) {
//        log.info("REST /vehicleStates-------/findByName/ : {}", name);
//        return ResponseEntity.ok(getVehicleStateUseCase.findByName(name));
//    }
    @GetMapping(value = "/vehicleUseStates/findByName/{name}")
    public List<VehicleStateDTO> findByName(@PathVariable("name") String name) {
        log.info("REST /vehicleStates/findByName/ : {}", name);
        return getVehicleStateUseCase.findByName(name);
    }

//    public List<VehicleStateDTO>  getAllVehicleStates() {
//        log.info("REST request to get all VehicleStateDTO");
//        return getVehicleStateUseCase.findAll();
//    }

    @PostMapping("/vehicleUseStates")
    public ResponseEntity<?> createVehicleState(
            @Valid @RequestBody FormVehicleStateDTO vehicleState)
            throws URISyntaxException {

        log.info("REST createVehicleState : {}", vehicleState.getName());
        String identifier = vehicleState.getIdentifier();

        CreateVehicleStateCommand command = new CreateVehicleStateCommand(
                identifier,
                vehicleState.getName(),
                vehicleState.getDescription()
        );

        createVehicleStateUseCase.create(command);

        return ResponseEntity.ok(vehicleState);
    }

    @PutMapping("/vehicleUseStates/{id}")
    public ResponseEntity<FormVehicleStateDTO> updateLabel(
            @PathVariable String id,
            @Valid @RequestBody FormVehicleStateDTO vehicleState)
            throws URISyntaxException {
        log.info("REST request to update vehicleStates : {}", vehicleState);
//        if (vehicleState.getId() == null) {
////            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
        UpdateVehicleStateCommand command = new UpdateVehicleStateCommand(
                vehicleState.getId(),
                vehicleState.getDescription()
        );
//
        vehicleStateUpdateUseCase.update(command);
        return ResponseEntity
                .ok()
                .headers(HeaderUtil.createEntityUpdateAlert("zygl", true, "vehicleStates", vehicleState.getId().toString()))
                .body(vehicleState);
    }

    @DeleteMapping("/vehicleUseStates/{id}")
    public ResponseEntity<Void> deleteVehicleState(@PathVariable String id) {
        log.info("REST request to delete vehicleStates : {}", id);
        DeleteVehicleStateCommand command = new DeleteVehicleStateCommand(id);

        vehicleStateDeleteUseCase.delete(command);
        return ResponseEntity
                .noContent()
                .headers(HeaderUtil.createEntityDeletionAlert("zygl", true, "vehicleStates", id.toString()))
                .build();
    }

}
