package mike.wolf.zygl.adapter.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.application.model.VehicleStateDTO;
import mike.wolf.zygl.application.port.in.GetVehicleStateUseCase;
import mike.wolf.zygl.common.WebAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jhipster.web.util.ResponseUtil;

import java.util.List;

@WebAdapter

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
public class VehicleStateController {
    private final GetVehicleStateUseCase getVehicleStateUseCase ;

    @GetMapping(value = "/helloworld")
    public String helloWorld(){
        return "Hello, welcome to COLA world!";
    }

    @GetMapping(value = "/vehicleState")
    public List<VehicleStateDTO>  getAllVehicleStates() {
        log.info("REST request to get all VehicleStateDTO");
        return getVehicleStateUseCase.findAll();
    }

    @GetMapping(value = "/vehicleState/{id}")
    public ResponseEntity<VehicleStateDTO>  getVehicleState(@PathVariable("id") String id) {
        log.debug("REST request to get VehicleStateDTO : {}", id);

        return ResponseUtil.wrapOrNotFound(getVehicleStateUseCase.findById(id));
    }

}
