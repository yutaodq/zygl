package mike.wolf.zygl.api.application.service;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.api.application.model.VehicleStateDTO;
import mike.wolf.zygl.api.application.model.VehicleTypeDTO;
import mike.wolf.zygl.api.application.port.in.vehicle.state.VehicleStataeExistesByNameQuery;
import mike.wolf.zygl.api.application.port.in.vehicle.type.ExistsByNameVehicleTypeUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.type.FindAllVehicleTypeUseCase;

import mike.wolf.zygl.api.application.port.in.vehicle.type.FindByIdVehicleTypeUseCase;
import mike.wolf.zygl.api.domain.vehicle.state.StateName;
import mike.wolf.zygl.api.domain.vehicle.type.TypeName;
import mike.wolf.zygl.api.domain.vehicle.type.VehicleTypeId;
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

public class VehicleTypeService implements
        FindAllVehicleTypeUseCase,
        FindByIdVehicleTypeUseCase,
        ExistsByNameVehicleTypeUseCase
{
    private final QueryGateway queryGateway;

    @Override
    public CompletableFuture<ResponseEntity<List<VehicleTypeDTO>>> findAll() {

        return queryGateway.query(
                FindAllVehicleTypeQuery.builder().build(),
                ResponseTypes.multipleInstancesOf(VehicleTypeDTO.class))
                .thenApply(this::wrapResultList);

    }

    @Override
    public CompletableFuture<ResponseEntity<VehicleTypeDTO>> findById(String id) {
        return queryGateway.query(
                FindByIdVehicleTypeQuery.builder()
                        .vehicleTypeId(VehicleTypeId.create(id))
                        .build(),
                ResponseTypes.instanceOf(VehicleTypeDTO.class)
        ).thenApply(this::wrapResult);
    }

    @Override
    public CompletableFuture<Boolean> existsByName(String name) {
        return queryGateway.query(
                ExistsByNameVehicleTypeQuery.builder()
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
