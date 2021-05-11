package mike.wolf.zygl.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.persistence.entities.VehicleTypeJpaEntity;
import mike.wolf.zygl.adapter.persistence.exception.DuplicatedNameException;
import mike.wolf.zygl.adapter.persistence.mappers.VehicleTypeMapper;
import mike.wolf.zygl.adapter.persistence.repositories.VehicleTypeRepository;
import mike.wolf.zygl.api.application.model.VehicleTypeDTO;
import mike.wolf.zygl.api.application.port.in.vehicle.type.ExistsByNameVehicleTypeUseCase.ExistsByNameVehicleTypeQuery;
import mike.wolf.zygl.api.application.port.in.vehicle.type.FindAllVehicleTypeUseCase.FindAllVehicleTypeQuery;
import mike.wolf.zygl.api.application.port.in.vehicle.type.FindByIdVehicleTypeUseCase.FindByIdVehicleTypeQuery;
import mike.wolf.zygl.api.application.port.in.vehicle.type.VehicleTypeCreateEvent;
import mike.wolf.zygl.api.application.port.in.vehicle.type.VehicleTypeDeleteEvent;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleTypeEventHandler {
    private final VehicleTypeRepository vehicleTypeRepository;

    /*
    Query
     */
    @QueryHandler
    public List<VehicleTypeDTO> find(final FindAllVehicleTypeQuery query) {
        return vehicleTypeRepository.findAll().stream()
                .map(VehicleTypeMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @QueryHandler
    public Optional<VehicleTypeDTO> findById(final FindByIdVehicleTypeQuery query) {
        String id = query.getVehicleTypeId().getIdentifier();
        return findById(id).map(VehicleTypeMapper.INSTANCE::toDto);
    }

    private Optional<VehicleTypeJpaEntity> findById(String id) {
        return vehicleTypeRepository.findById(id);
    }

    @QueryHandler
    public boolean existsByName(final ExistsByNameVehicleTypeQuery query) {
        return vehicleTypeRepository.existsByName(query.getTypeName().getName());
    }

    /*
      Command
    */
    @EventHandler
    public void on(final VehicleTypeCreateEvent event) {
        log.info("VehicleTypeEventHandler on(VehicleTypeCreateEvent event) : {}", event.getVehicleTypeId().getIdentifier());
        VehicleTypeJpaEntity entity = VehicleTypeJpaEntity.builder()
                .id(event.getVehicleTypeId().getIdentifier())
                .name(event.getTypeName().getName())
                .description(event.getDescription())
                .build();
        try {
            vehicleTypeRepository.save(entity);

        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new DuplicatedNameException(entity.getName());
        }

    }

    @EventHandler
    public void on(final VehicleTypeDeleteEvent event) {
        vehicleTypeRepository.deleteById(event.getVehicleTypeId().getIdentifier());
    }

}
