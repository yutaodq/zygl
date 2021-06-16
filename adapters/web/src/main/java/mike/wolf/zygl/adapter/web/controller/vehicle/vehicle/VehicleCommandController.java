package mike.wolf.zygl.adapter.web.controller.vehicle.vehicle;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.web.model.FormVehicleDTO;
import mike.wolf.zygl.adapter.web.service.VehicleFacade;
import mike.wolf.zygl.api.application.model.VehicleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;

import javax.validation.Valid;
import java.net.URISyntaxException;

@RestController
@Slf4j
@RequestMapping("/vehicles")
@RequiredArgsConstructor
@CrossOrigin
public class VehicleCommandController {
    private final VehicleFacade vehicleFacade;

    @PostMapping()
    public ResponseEntity<?> createVehicle(
            @Valid @RequestBody FormVehicleDTO formVehicleDTO)
            throws URISyntaxException {

        log.info("REST createVehicle : {}", formVehicleDTO.getName());
        vehicleFacade.create(formVehicleDTO);

//        return ResponseEntity.ok(formVehicleDTO);
        return ResponseEntity.ok("a");
    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteVehicleState(@PathVariable String id) {
//        log.info("REST request to delete vehicleStates : {}", id);
//        vehicleFacade.deleteVehicle(id);
//        return ResponseEntity
//                .noContent()
//                .headers(HeaderUtil.createEntityDeletionAlert("zygl", true, "vehicleStates", id.toString()))
//                .build();
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<FormVehicleDTO> updateVehicleState(
//            @PathVariable String id,
//            @Valid @RequestBody FormVehicleDTO formVehicleDTO)
//            throws URISyntaxException {
//        log.info("REST request to update vehicles : {}", formVehicleDTO);
//        vehicleFacade.updateVehicle(formVehicleDTO);
//
//        return ResponseEntity
//                .ok()
//                .headers(HeaderUtil.createEntityUpdateAlert("zygl", true, "vehicleStates", formVehicleDTO.getId().toString()))
//                .body(formVehicleDTO);
//    }
}
