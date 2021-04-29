package mike.wolf.zygl.adapter.persistence.adapter;

import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.persistence.entities.VehicleStateJpaEntity;
import mike.wolf.zygl.adapter.persistence.exception.DuplicatedNameException;
import mike.wolf.zygl.adapter.persistence.mappers.VehicleStateMapper;
import mike.wolf.zygl.adapter.persistence.repositories.VehicleStateRepository;
import mike.wolf.zygl.api.vehicle.state.FindAllVehicleStateQuery;
import mike.wolf.zygl.api.vehicle.state.VehicleStataeExistesByNameQuery;
import mike.wolf.zygl.api.vehicle.state.VehicleStateByIdQuery;
import mike.wolf.zygl.api.vehicle.state.VehicleStateCreateEvent;
import mike.wolf.zygl.application.model.VehicleStateDTO;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class VehicleStateEventHandler {
    private final VehicleStateRepository vehicleStateRepository;

    public VehicleStateEventHandler(VehicleStateRepository vehicleStateRepository) {
        this.vehicleStateRepository = vehicleStateRepository;
    }

    @QueryHandler
    public List<VehicleStateDTO> find(FindAllVehicleStateQuery query) {
        return vehicleStateRepository.findAll().stream()
                .map(VehicleStateMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
     }

    @QueryHandler
    public Optional<VehicleStateDTO> findById(VehicleStateByIdQuery query) {
        Optional<VehicleStateJpaEntity> vehicleState = vehicleStateRepository.findById(query.getVehicleStateId().getIdentifier());
        return vehicleState.map(VehicleStateMapper.INSTANCE::toDto);
    }
    @QueryHandler
    public boolean existsByName(VehicleStataeExistesByNameQuery query) {
        return vehicleStateRepository.existsByName(query.getStateName().getName());
//        vehicleStateRepository.existsByName(query.getStateName().getName())
//                .flatMap(Mono.just(false) )
//        return vehicleStateRepository.existsByName(query.getStateName().getName())
//                .flatMap { Mono.just(false) }
//                .switchIfEmpty(Mono.just(true))
//                .toFuture()

    }
//    @QueryHandler
//    fun handleIsEmailUniqueQuery(query: IsEmailUniqueQuery): CompletableFuture<Boolean> =
//            accountRepository.findAccountByEmail(query.email)
//            .flatMap { Mono.just(false) }
//                .switchIfEmpty(Mono.just(true))
//            .toFuture()

    @EventHandler
    public void on(VehicleStateCreateEvent event) {
        VehicleStateJpaEntity entity = VehicleStateJpaEntity.builder()
                .id(event.getVehicleStateId().getIdentifier())
                .name(event.getStateName().getName())
                .description(event.getDescription())
                .build();
        try {
            vehicleStateRepository.save(entity).getId();

        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new DuplicatedNameException(entity.getName());
        }
//        CompanyView companyView = new CompanyView();
//
//        companyView.setIdentifier(event.getCompanyId().getIdentifier());
//        companyView.setValue(event.getCompanyValue());
//        companyView.setAmountOfShares(event.getAmountOfShares());
//        companyView.setTradeStarted(true);
//        companyView.setName(event.getCompanyName());
//
//        companyRepository.save(companyView);
    }


}