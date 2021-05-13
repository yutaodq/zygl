package mike.wolf.zygl.adapter.web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import mike.wolf.zygl.api.application.port.in.vehicle.state.*;
import mike.wolf.zygl.api.domain.vehicle.state.StateName;
import mike.wolf.zygl.api.domain.vehicle.state.VehicleStateId;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import mike.wolf.zygl.api.application.model.VehicleStateDTO;
import mike.wolf.zygl.adapter.web.model.FormVehicleStateDTO;

@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleStateFacade {
    private final FindAllVehicleStateUseCase findAllVehicleStateUseCase;
    private final FindByIdVehicleStateUseCase findByIdVehicleStateUseCase;
    private final ExistsByNameVehicleStateUseCase existsByNameVehicleStateUseCase;
    private final DeleteVehicleStateUseCase deleteVehicleStateUseCase;
    private final CreateVehicleStateUseCase createVehicleStateUseCase;
    private final UpdateVehicleStateUseCase updateVehicleStateUseCase;
    private final UpdateVehicleStateNameUseCase updateVehicleStateNameUseCase;

    /*
    query
     */
    public CompletableFuture<ResponseEntity<List<VehicleStateDTO>>> findAllVehicleStates() {
        return findAllVehicleStateUseCase.findAll();
    }

    public CompletableFuture<ResponseEntity<VehicleStateDTO>> findById(String id) {
        return findByIdVehicleStateUseCase.findById(id);

    }

    public CompletableFuture<Boolean> existsByName(String name) {
        return existsByNameVehicleStateUseCase.existsByName(name);
    }

    /*
    command
     */
    public void deleteVehicleState(String id) {
        deleteVehicleStateUseCase.deleteVehicleState(id);
    }

    public void createVehicleState(FormVehicleStateDTO formVehicleState)
            throws URISyntaxException {
        log.info("VehicleStateFacade REST createVehicleState : {}", formVehicleState.getDescription());

        CreateVehicleStateUseCase.CreateVehicleStateCommand command = CreateVehicleStateUseCase.CreateVehicleStateCommand
                .builder()
                .vehicleStateId(VehicleStateId.create(formVehicleState.getId()))
                .stateName(StateName.create(formVehicleState.getName()))
                .description(formVehicleState.getDescription())
                .build();
        createVehicleStateUseCase.createVehicleState(command);
    }

    public void updateVehicleState(FormVehicleStateDTO dto) {
        String updateType = dto.getUpdateType();
        switch (updateType) {
            case "updateName":
                this.updateName(dto);
                break;
            default:
                this.updateDefault(dto);

        }
    }

    private void updateDefault(FormVehicleStateDTO dto) {
        UpdateVehicleStateUseCase.UpdateVehicleStateCommand command = UpdateVehicleStateUseCase.UpdateVehicleStateCommand
                .builder()
                .vehicleStateId(VehicleStateId.create(dto.getId()))
                .description(dto.getDescription())
                .build();
        updateVehicleStateUseCase.update(command);
    }

    private void updateName(FormVehicleStateDTO dto) {
        UpdateVehicleStateNameUseCase.UpdateVehicleStateNameCommand command = UpdateVehicleStateNameUseCase.UpdateVehicleStateNameCommand
                .builder()
                .vehicleStateId(VehicleStateId.create(dto.getId()))
                .stateName(StateName.create(dto.getName()))
                .build();
        updateVehicleStateNameUseCase.updateName(command);

    }

}
