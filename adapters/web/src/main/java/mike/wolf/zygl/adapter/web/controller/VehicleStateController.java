package mike.wolf.zygl.adapter.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.application.port.in.VehicleStateQueryUseCase;
import mike.wolf.zygl.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

@WebAdapter

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
public class VehicleStateController {
    private final VehicleStateQueryUseCase getVehicleStateUseCase ;

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
    /**
     * {@code POST  /labels} : Create a new label.
     *
     * @param label the label to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new label, or with status {@code 400 (Bad Request)} if the label has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/vehicleStates")
    public ResponseEntity<Label> createLabel(@Valid @RequestBody Label label) throws URISyntaxException {
    }

//    @PostMapping("/labels")
//    public ResponseEntity<Label> createLabel(@Valid @RequestBody Label label) throws URISyntaxException {
//        log.debug("REST request to save Label : {}", label);
//        if (label.getId() != null) {
//            throw new BadRequestAlertException("A new label cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        Label result = labelRepository.save(label);
//        return ResponseEntity
//                .created(new URI("/api/labels/" + result.getId()))
//                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
//                .body(result);
//    }

}
