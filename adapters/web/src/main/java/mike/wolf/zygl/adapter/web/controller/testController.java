package mike.wolf.zygl.adapter.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/hello")
@RequiredArgsConstructor
@CrossOrigin
public class testController {
    @GetMapping()
    public String helloWorld() {
        log.info("REST request to get all VehicleStateDTO");
        return "Hello, welcome to COLA world!";
    }
}
