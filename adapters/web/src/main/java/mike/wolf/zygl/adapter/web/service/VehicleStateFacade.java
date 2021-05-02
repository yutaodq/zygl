package mike.wolf.zygl.adapter.web.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.api.vehicle.state.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

import mike.wolf.zygl.adapter.web.model.FormVehicleStateDTO;
import mike.wolf.zygl.application.model.VehicleStateDTO;

@Slf4j
@RequiredArgsConstructor

@Service
public class VehicleStateFacade {
    private final QueryGateway queryGateway;
    private final CommandGateway commandGateway;

    public CompletableFuture<ResponseEntity<List<VehicleStateDTO>>> findAllVehicleStates() {
        return queryGateway.query(new FindAllVehicleStateQuery(),
                ResponseTypes.multipleInstancesOf(VehicleStateDTO.class))
                .thenApply(this::wrapResultList);
    }

    public CompletableFuture<ResponseEntity<VehicleStateDTO>> findById(String id) {
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
//        String identifier = vehicleState.getIdentifier();

        CreateVehicleStateCommand command = CreateVehicleStateCommand
                .builder()
                .vehicleStateId(VehicleStateId.create(vehicleState.getId()))
                .stateName(StateName.create(vehicleState.getName()))
                .description(vehicleState.getDescription())
                .build();

        commandGateway.sendAndWait(command);
        return ResponseEntity.ok(vehicleState);
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
