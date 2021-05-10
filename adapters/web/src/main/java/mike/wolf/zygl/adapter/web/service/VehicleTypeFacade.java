package mike.wolf.zygl.adapter.web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.api.application.model.VehicleTypeDTO;
import mike.wolf.zygl.api.application.port.in.vehicle.type.FindAllVehicleTypeUseCase;
import mike.wolf.zygl.application.port.in.SendMoneyUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleTypeFacade {
    private final FindAllVehicleTypeUseCase findAllVehicleTypeUseCase;

    public CompletableFuture<ResponseEntity<List<VehicleTypeDTO>>> findAllVehicleTypes() {
        return findAllVehicleTypeUseCase.findAll();
    }
}
