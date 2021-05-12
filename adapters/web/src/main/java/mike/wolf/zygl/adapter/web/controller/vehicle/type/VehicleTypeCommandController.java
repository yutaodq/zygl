package mike.wolf.zygl.adapter.web.controller.vehicle.type;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.web.model.FormVehicleTypeDTO;
import mike.wolf.zygl.adapter.web.service.VehicleTypeFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;

import javax.validation.Valid;
import java.net.URISyntaxException;

@RestController
@Slf4j
@RequestMapping("/vehicleUseTypes")
@RequiredArgsConstructor
@CrossOrigin
public class VehicleTypeCommandController {
    private final VehicleTypeFacade vehicleTypeFacade;

    @PostMapping()
    public ResponseEntity<?> createVehicleState(
            @Valid @RequestBody FormVehicleTypeDTO formVehicleTypeDTO)
            throws URISyntaxException {

        log.info("REST createVehicleState : {}", formVehicleTypeDTO.getName());
        vehicleTypeFacade.createVehicleState(formVehicleTypeDTO);

        return ResponseEntity.ok(formVehicleTypeDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicleState(@PathVariable String id) {
        log.info("REST request to delete vehicleStates : {}", id);
        vehicleTypeFacade.deleteVehicleType(id);
        return ResponseEntity
                .noContent()
                .headers(HeaderUtil.createEntityDeletionAlert("zygl", true, "vehicleStates", id.toString()))
                .build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<FormVehicleTypeDTO> updateVehicleState(
            @PathVariable String id,
            @Valid @RequestBody FormVehicleTypeDTO formVehicleTypeDTO)
            throws URISyntaxException {
        log.info("REST request to update vehicleTypes : {}", formVehicleTypeDTO);
        vehicleTypeFacade.updateVehicleType(formVehicleTypeDTO);

        return ResponseEntity
                .ok()
                .headers(HeaderUtil.createEntityUpdateAlert("zygl", true, "vehicleStates", formVehicleTypeDTO.getId().toString()))
                .body(formVehicleTypeDTO);
    }
}
