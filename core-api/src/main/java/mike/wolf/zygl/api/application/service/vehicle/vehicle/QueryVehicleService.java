package mike.wolf.zygl.api.application.service.vehicle.vehicle;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.api.application.model.VehicleDTO;
import mike.wolf.zygl.api.application.port.in.vehicle.type.ExistsByNameVehicleTypeUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.vehicle.ExistsByNbpzVehicleUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.vehicle.ExistsByPzVehicleUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.vehicle.FindAllVehicleUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.vehicle.FindByIdVehicleUseCase;
import mike.wolf.zygl.api.domain.vehicle.type.TypeName;
import mike.wolf.zygl.api.domain.vehicle.vehicle.VehicleId;
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

public class QueryVehicleService implements
        FindAllVehicleUseCase,
        FindByIdVehicleUseCase,
        ExistsByPzVehicleUseCase,
        ExistsByNbpzVehicleUseCase


{
    private final QueryGateway queryGateway;

    @Override
    public CompletableFuture<ResponseEntity<List<VehicleDTO>>> findAll() {
        return queryGateway.query(
                FindAllQuery.builder().build(),
                ResponseTypes.multipleInstancesOf(VehicleDTO.class))
                .thenApply(this::wrapResultList);

    }

    @Override
    public CompletableFuture<ResponseEntity<VehicleDTO>> findById(String id) {
        return queryGateway.query(
                FindByIdQuery.builder()
                        .vehicleId(VehicleId.create(id))
                        .build(),
                ResponseTypes.instanceOf(VehicleDTO.class)
        ).thenApply(this::wrapResult);
    }

    @Override
    public CompletableFuture<Boolean> existsByPz(String pz) {
        return queryGateway.query(
                ExistsByPzVehicleUseCase.ExistsByPzQuery.builder()
                        .pz(pz)
                        .build(),
                ResponseTypes.instanceOf(Boolean.class)
        );
    }

    @Override
    public CompletableFuture<Boolean> existsByNbpz(String nbpz) {
        return queryGateway.query(
                ExistsByNbpzVehicleUseCase.ExistsByNbpzQuery.builder()
                        .nbpz(nbpz)
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
