package mike.wolf.zygl.api.application.service.vehicle.state;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.api.application.model.VehicleStateDTO;
import mike.wolf.zygl.api.application.port.in.vehicle.state.ExistsByNameVehicleStateUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.state.FindAllVehicleStateUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.state.FindByIdVehicleStateUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.type.ExistsByNameVehicleTypeUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.type.FindAllVehicleTypeUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.type.FindByIdVehicleTypeUseCase;
import mike.wolf.zygl.api.domain.vehicle.state.VehicleStateId;
import mike.wolf.zygl.api.domain.vehicle.type.TypeName;
import mike.wolf.zygl.common.UseCase;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

@RequiredArgsConstructor
@UseCase

public class VehicleStateQueryService implements
        FindAllVehicleStateUseCase,
        FindByIdVehicleStateUseCase,
        ExistsByNameVehicleStateUseCase
{
    private final QueryGateway queryGateway;

    @Override
    public CompletableFuture<ResponseEntity<List<VehicleStateDTO>>> findAll() {

        return queryGateway.query(
                FindAllVehicleStateQuery.builder().build(),
                ResponseTypes.multipleInstancesOf(VehicleStateDTO.class))
                .thenApply(this::wrapResultList);

    }

    @Override
    public CompletableFuture<ResponseEntity<VehicleStateDTO>> findById(String id) {
        return queryGateway.query(
                FindByIdVehicleStateQuery.builder()
                        .vehicleStateId(VehicleStateId.create(id))
                        .build(),
                ResponseTypes.instanceOf(VehicleStateDTO.class)
        ).thenApply(this::wrapResult);
    }

    @Override
    public CompletableFuture<Boolean> existsByName(String name) {
        return queryGateway.query(
                ExistsByNameVehicleStateQuery.builder()
                        .typeName(TypeName.create(name))
                        .build(),
                ResponseTypes.instanceOf(Boolean.class)
        );
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
