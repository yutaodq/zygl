package mike.wolf.zygl.adapter.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.web.model.FormVehicleStateDTO;
import mike.wolf.zygl.adapter.web.service.VehicleStateFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;

import javax.validation.Valid;
import java.net.URISyntaxException;

@RestController
@Slf4j
@RequestMapping("/vehicleUseStates")
@RequiredArgsConstructor
@CrossOrigin
public class VehicleStateCommandController {
    private final VehicleStateFacade vehicleStateFacade;

    @PostMapping()
    public ResponseEntity<?> createVehicleState(
            @Valid @RequestBody FormVehicleStateDTO formVehicleStateDTO)
            throws URISyntaxException {

        log.info("REST createVehicleState : {}", formVehicleStateDTO.getName());
        return vehicleStateFacade.createVehicleState(formVehicleStateDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicleState(@PathVariable String id) {
        log.info("REST request to delete vehicleStates : {}", id);
        vehicleStateFacade.deleteVehicleState(id);
        return ResponseEntity
                .noContent()
                .headers(HeaderUtil.createEntityDeletionAlert("zygl", true, "vehicleStates", id.toString()))
                .build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<FormVehicleStateDTO> updateVehicleState(
            @PathVariable String id,
            @Valid @RequestBody FormVehicleStateDTO vehicleState)
            throws URISyntaxException {
        log.info("REST request to update vehicleStates : {}", vehicleState);
        vehicleStateFacade.updateVehicleState(vehicleState);

        return ResponseEntity
                .ok()
                .headers(HeaderUtil.createEntityUpdateAlert("zygl", true, "vehicleStates", vehicleState.getId().toString()))
                .body(vehicleState);
    }
    @PutMapping("/updateName/{id}")
    public ResponseEntity<FormVehicleStateDTO> updateVehicleStateName(
            @PathVariable String id,
            @Valid @RequestBody FormVehicleStateDTO vehicleState)
            throws URISyntaxException {
        log.info("REST request to update vehicleStates : {}", vehicleState);
        vehicleStateFacade.updateVehicleState(vehicleState);

        return ResponseEntity
                .ok()
                .headers(HeaderUtil.createEntityUpdateAlert("zygl", true, "vehicleStates", vehicleState.getId().toString()))
                .body(vehicleState);
    }

}
