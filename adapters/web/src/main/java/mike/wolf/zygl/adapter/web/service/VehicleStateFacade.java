package mike.wolf.zygl.adapter.web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import mike.wolf.zygl.adapter.web.model.FormVehicleStateUpdateDTO;
import mike.wolf.zygl.api.application.port.in.vehicle.state.*;
import mike.wolf.zygl.api.domain.vehicle.state.StateName;
import mike.wolf.zygl.api.domain.vehicle.state.VehicleStateId;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

import mike.wolf.zygl.api.application.model.VehicleStateDTO;
import mike.wolf.zygl.adapter.web.model.FormVehicleStateDTO;

@Slf4j
@RequiredArgsConstructor

@Service
public class VehicleStateFacade {
    private final QueryGateway queryGateway;
    private final CommandGateway commandGateway;

    public CompletableFuture<ResponseEntity<List<VehicleStateDTO>>> findAllVehicleStates() {
        return queryGateway.query(FindAllVehicleStateQuery.builder().build(),
                ResponseTypes.multipleInstancesOf(VehicleStateDTO.class))
                .thenApply(this::wrapResultList);
    }

    public CompletableFuture<ResponseEntity<VehicleStateDTO>> findById(String id) {
        VehicleStateByIdQuery query = VehicleStateByIdQuery.builder()
                .vehicleStateId(VehicleStateId.create(id))
                .build();

        return queryGateway.query(
                VehicleStateByIdQuery
                        .builder()
                        .vehicleStateId(VehicleStateId.create(id))
                        .build(),
                ResponseTypes.instanceOf(VehicleStateDTO.class))
                .thenApply(this::wrapResult);
    }

    public CompletableFuture<Boolean> existsByName(String name) {
        return queryGateway.query(
                VehicleStataeExistesByNameQuery
                        .builder()
                        .stateName(StateName.create(name))
                        .build(),
                ResponseTypes.instanceOf(Boolean.class))
                ;
    }


    public ResponseEntity<?> createVehicleState(FormVehicleStateDTO vehicleState)
            throws URISyntaxException {
        log.info("VehicleStateFacade REST createVehicleState : {}", vehicleState.getDescription());

        CreateVehicleStateCommand command = CreateVehicleStateCommand
                .builder()
                .vehicleStateId(VehicleStateId.create(vehicleState.getId()))
                .stateName(StateName.create(vehicleState.getName()))
                .description(vehicleState.getDescription())
                .build();

        commandGateway.sendAndWait(command);
        return ResponseEntity.ok(vehicleState);
    }

    public void deleteVehicleState(String id) {
        DeleteVehicleStateCommand command = DeleteVehicleStateCommand
                .builder()
                .vehicleStateId(VehicleStateId.create(id))
                .build();
        commandGateway.send(command);

    }
//    public void updateVehicleState(FormVehicleStateUpdateDTO dto) {
//        UpdateVehicleStateCommand command = UpdateVehicleStateCommand
//                .builder()
//                .vehicleStateId(VehicleStateId.create(dto.getId()))
//                .description(dto.getDescription())
//                .build();
//        commandGateway.send(command);
//
//    }
    public void updateVehicleState(FormVehicleStateDTO dto) {
        UpdateVehicleStateCommand command = UpdateVehicleStateCommand
                .builder()
                .vehicleStateId(VehicleStateId.create(dto.getId()))
                .description(dto.getDescription())
                .build();
        commandGateway.send(command);

    }

    /*

     */
    @NotNull
    private <T> ResponseEntity<T> wrapResult(T result) {
        return wrapResult(Objects::isNull, result);
    }

    @NotNull
    private <T> ResponseEntity<List<T>> wrapResultList(List<T> result) {
        return wrapResult(resultList -> Objects.isNull(resultList) || resultList.isEmpty(), result);
    }


    @NotNull
    private <T> ResponseEntity<T> wrapResult(Predicate<T> assertResult, T result) {
        return assertResult.test(result) ? ResponseEntity.notFound().build() : ResponseEntity.ok(result);
    }

}
