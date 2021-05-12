package mike.wolf.zygl.adapter.web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.web.model.FormVehicleTypeDTO;
import mike.wolf.zygl.api.application.model.VehicleTypeDTO;
import mike.wolf.zygl.api.application.port.in.vehicle.type.FindAllVehicleTypeUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.type.FindByIdVehicleTypeUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.type.ExistsByNameVehicleTypeUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.type.DeleteVehicleTypeUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.type.CreateVehicleTypeUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.type.CreateVehicleTypeUseCase.CreateVehicleTypeCommand;

import mike.wolf.zygl.api.domain.vehicle.type.TypeName;
import mike.wolf.zygl.api.domain.vehicle.type.VehicleTypeId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleTypeFacade {

    private final FindAllVehicleTypeUseCase findAllVehicleTypeUseCase;
    private final FindByIdVehicleTypeUseCase findByIdVehicleTypeUseCase;
    private final ExistsByNameVehicleTypeUseCase existsByNameVehicleTypeUseCase;
    private final DeleteVehicleTypeUseCase deleteVehicleTypeUseCase;
    private final CreateVehicleTypeUseCase createVehicleTypeUseCase;

    /*
    query
     */
    public CompletableFuture<ResponseEntity<List<VehicleTypeDTO>>> findAllVehicleTypes() {
        return findAllVehicleTypeUseCase.findAll();
    }

    public CompletableFuture<ResponseEntity<VehicleTypeDTO>> findById(String id) {
        return findByIdVehicleTypeUseCase.findById(id);

    }

    public CompletableFuture<Boolean> existsByName(String name) {
        return existsByNameVehicleTypeUseCase.existsByName(name);
    }

/*
command
 */
    public void deleteVehicleType(String id) {
         deleteVehicleTypeUseCase.deleteVehicleType(id);
    }

    public void createVehicleState(FormVehicleTypeDTO formVehicleType)
            throws URISyntaxException {
        log.info("VehicleTypeFacade REST createVehicleType : {}", formVehicleType.getDescription());

        CreateVehicleTypeCommand command = CreateVehicleTypeCommand
                .builder()
                .vehicleTypeId(VehicleTypeId.create(formVehicleType.getId()))
                .typeName(TypeName.create(formVehicleType.getName()))
                .description(formVehicleType.getDescription())
                .build();
        createVehicleTypeUseCase.createVehicleType(command);
    }

    public void updateVehicleType(FormVehicleTypeDTO formVehicleTypeDTO) {
    }
}
