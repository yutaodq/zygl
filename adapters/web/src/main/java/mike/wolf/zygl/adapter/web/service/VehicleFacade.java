package mike.wolf.zygl.adapter.web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.web.model.FormVehicleDTO;
import mike.wolf.zygl.api.application.model.VehicleDTO;

import mike.wolf.zygl.api.application.port.in.vehicle.vehicle.*;
import mike.wolf.zygl.api.domain.vehicle.vehicle.VehicleId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleFacade {

    private final FindAllVehicleUseCase findAllVehicleUseCase;
    private final FindByIdVehicleUseCase findByIdVehicleUseCase;
//    private final ExistsByNameVehicleUseCase existsByNameVehicleUseCase;
//    private final DeleteVehicleUseCase deleteVehicleUseCase;
//    private final CreateVehicleUseCase createVehicleUseCase;
//    private final UpdateVehicleUseCase updateVehicleUseCase;
//    private final UpdateVehicleNameUseCase updateVehicleNameUseCase;

    /*
    query
     */
    public CompletableFuture<ResponseEntity<List<VehicleDTO>>> findAllVehicles() {
        return findAllVehicleUseCase.findAll();
    }

    public CompletableFuture<ResponseEntity<VehicleDTO>> findById(String id) {
        return findByIdVehicleUseCase.findById(id);

    }

//    public CompletableFuture<Boolean> existsByName(String name) {
//        return existsByNameVehicleUseCase.existsByName(name);
//    }

/*
command
 */
//    public void deleteVehicle(String id) {
//         deleteVehicleUseCase.deleteVehicle(id);
//    }

//    public void createVehicleState(FormVehicleDTO formVehicle)
//            throws URISyntaxException {
//        log.info("VehicleFacade REST createVehicle : {}", formVehicle.getDescription());
//
//        CreateVehicleCommand command = CreateVehicleCommand
//                .builder()
//                .vehicleId(VehicleId.create(formVehicle.getId()))
//                .typeName(TypeName.create(formVehicle.getName()))
//                .description(formVehicle.getDescription())
//                .build();
//        createVehicleUseCase.createVehicle(command);
//    }
//
//    public void updateVehicle(FormVehicleDTO dto) {
//        String updateType = dto.getUpdateType();
//        switch (updateType) {
//            case "updateName":
//                this.updateName(dto);
//                break;
//            default:
//                this.updateDefault(dto);
//
//        }
//    }
//
//    private void updateDefault(FormVehicleDTO dto) {
//        UpdateVehicleCommand command = UpdateVehicleCommand
//                .builder()
//                .vehicleId(VehicleId.create(dto.getId()))
//                .description(dto.getDescription())
//                .build();
//        updateVehicleUseCase.update(command);
//    }
//
//    private void updateName(FormVehicleDTO dto) {
//        UpdateVehicleNameCommand command = UpdateVehicleNameCommand
//                .builder()
//                .vehicleId(VehicleId.create(dto.getId()))
//                .typeName(TypeName.create(dto.getName()))
//                .build();
//        updateVehicleNameUseCase.updateName(command);
//
//    }
}
