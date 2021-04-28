package mike.wolf.zygl.adapter.web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.web.model.FormVehicleStateDTO;
import mike.wolf.zygl.api.vehicle.state.FindAllVehicleStateQuery;
import mike.wolf.zygl.application.model.VehicleStateDTO;
import mike.wolf.zygl.application.port.in.VehicleStateCreateUseCase;
import mike.wolf.zygl.application.port.in.VehicleStateCreateUseCase.CreateVehicleStateCommand;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleStateFacade {
    private final VehicleStateCreateUseCase createVehicleStateUseCase;
    private final QueryGateway queryGateway;

    public CompletableFuture<ResponseEntity<List<VehicleStateDTO>>> findAllVehicleStates() {
        return queryGateway.query(new FindAllVehicleStateQuery(),
                ResponseTypes.multipleInstancesOf(VehicleStateDTO.class))
                .thenApply(this::wrapResultList);
    }

    public ResponseEntity<?> createVehicleState( FormVehicleStateDTO vehicleState)
            throws URISyntaxException {

        log.info("VehicleStateFacade REST createVehicleState : {}", vehicleState.getName());
        String identifier = vehicleState.getIdentifier();

        CreateVehicleStateCommand command = new CreateVehicleStateCommand(
                identifier,
                vehicleState.getName(),
                vehicleState.getDescription()
        );

        createVehicleStateUseCase.create(command);

        return ResponseEntity.ok(vehicleState);
    }

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
