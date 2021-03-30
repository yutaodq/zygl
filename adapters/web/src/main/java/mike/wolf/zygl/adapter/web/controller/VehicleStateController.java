package mike.wolf.zygl.adapter.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.application.model.VehicleStateDTO;
import mike.wolf.zygl.application.port.in.GetVehicleStateUseCase;
import mike.wolf.zygl.common.WebAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@WebAdapter

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
public class VehicleStateController {
    private final GetVehicleStateUseCase getVehicleStateUseCase ;

//    @Autowired
//    public VehicleStateController(
//            GetVehicleStateUseCase getVehicleStateService
//        ) {
//        this.getVehicleStateUseCase = getVehicleStateUseCase;
//    }// ProductsController()

    @GetMapping(value = "/helloworld")
    public String helloWorld(){
        return "Hello, welcome to COLA world!";
    }

    @GetMapping(value = "/vehicleState")
    public List<VehicleStateDTO>  getAllVehicleStates() {
        log.info("aaaaaaaaaaaaaaaaaa");
        return getVehicleStateUseCase.findAll();
    }

}
