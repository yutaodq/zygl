package mike.wolf.zygl.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.persistence.entities.VehicleJpaEntity;
import mike.wolf.zygl.adapter.persistence.mappers.VehicleMapper;
import mike.wolf.zygl.adapter.persistence.repositories.VehicleRepository;
import mike.wolf.zygl.api.application.model.VehicleDTO;
import mike.wolf.zygl.api.application.port.in.vehicle.vehicle.FindAllVehicleUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.vehicle.FindByIdVehicleUseCase;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleEventHandler {
    private final VehicleRepository vehicleRepository;

    /*
    Query
     */
    @QueryHandler
    public List<VehicleDTO> find(final FindAllVehicleUseCase.FindAllQuery query) {
        return vehicleRepository.findAll().stream()
                .map(VehicleMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @QueryHandler
    public Optional<VehicleDTO> findById(final FindByIdVehicleUseCase.FindByIdQuery query) {
        String id = query.getVehicleId().getIdentifier();
        return findById(id).map(VehicleMapper.INSTANCE::toDto);
    }

    private Optional<VehicleJpaEntity> findById(String id) {
        return vehicleRepository.findById(id);
    }

//    @QueryHandler
//    public boolean existsByName(final ExistsByNameVehicleQuery query) {
//        return vehicleRepository.existsByName(query.getTypeName().getName());
//    }
//
//    /*
//      Command
//    */
//    @EventHandler
//    public void on(final VehicleCreateEvent event) {
//        log.info("VehicleEventHandler on(VehicleCreateEvent event) : {}", event.getVehicleId().getIdentifier());
//        VehicleJpaEntity entity = VehicleJpaEntity.builder()
//                .id(event.getVehicleId().getIdentifier())
//                .name(event.getTypeName().getName())
//                .description(event.getDescription())
//                .build();
//        try {
//            vehicleRepository.save(entity);
//
//        } catch (DataIntegrityViolationException e) {
//            e.printStackTrace();
//            throw new DuplicatedNameException(entity.getName());
//        }
//
//    }
//
//    @EventHandler
//    public void on(final VehicleDeleteEvent event) {
//        log.info("VehicleEventHandler on(VehicleDeleteEvent event) : {}", event.getVehicleId().getIdentifier());
//
//        vehicleRepository.deleteById(event.getVehicleId().getIdentifier());
//    }
//    @EventHandler
//    public void on(final VehicleUpdateEvent event) {
//        String id = event.getVehicleId().getIdentifier();
//        VehicleJpaEntity vehicle = findById(id).map(data -> {
//            VehicleJpaEntity entity = data;
//            entity.setDescription(event.getDescription());
//            return entity;
//        }).get();
//        vehicleRepository.save(vehicle);
//    }
//
//    @EventHandler
//    public void on(final VehicleUpdateNameEvent event) {
//        String id = event.getVehicleId().getIdentifier();
//        VehicleJpaEntity vehicle = findById(id).map(data -> {
//            VehicleJpaEntity entity = data;
//            entity.setName(event.getTypeName().getName());
//            return entity;
//        }).get();
//        vehicleRepository.save(vehicle);
//    }

}
