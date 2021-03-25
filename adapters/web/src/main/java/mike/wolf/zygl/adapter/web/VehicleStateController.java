package mike.wolf.zygl.adapter.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api")
public class VehicleStateController {
    @GetMapping(value = "/vehicleState", produces = MediaTypes.HAL_JSON_VALUE)
    public List<VehicleStateJpaEntity> getAllProducts() {
        log.info("所有的工具记录");
//        return productService.findAllProduct();
    }

}
