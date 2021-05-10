package mike.wolf.zygl.adapter.web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.api.application.model.VehicleTypeDTO;
import mike.wolf.zygl.api.application.port.in.vehicle.type.ExistsByNameVehicleTypeUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.type.FindAllVehicleTypeUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.type.FindByIdVehicleTypeUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleTypeFacade {
    private final FindAllVehicleTypeUseCase findAllVehicleTypeUseCase;
    private final FindByIdVehicleTypeUseCase findByIdVehicleTypeUseCase;
    private final ExistsByNameVehicleTypeUseCase existsByNameVehicleTypeUseCase;

    public CompletableFuture<ResponseEntity<List<VehicleTypeDTO>>> findAllVehicleTypes() {
        return findAllVehicleTypeUseCase.findAll();
    }

    public CompletableFuture<ResponseEntity<VehicleTypeDTO>> findById(String id) {
        return findByIdVehicleTypeUseCase.findById(id);

    }

    public CompletableFuture<Boolean> existsByName(String name) {
        return existsByNameVehicleTypeUseCase.existsByName(name);
    }

}
