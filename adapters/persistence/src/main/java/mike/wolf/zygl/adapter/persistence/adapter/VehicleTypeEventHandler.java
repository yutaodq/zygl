package mike.wolf.zygl.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.persistence.entities.VehicleTypeJpaEntity;
import mike.wolf.zygl.adapter.persistence.mappers.VehicleTypeMapper;
import mike.wolf.zygl.adapter.persistence.repositories.VehicleTypeRepository;
import mike.wolf.zygl.api.application.model.VehicleTypeDTO;
import mike.wolf.zygl.api.application.port.in.vehicle.type.ExistsByNameVehicleTypeUseCase.ExistsByNameVehicleTypeQuery;
import mike.wolf.zygl.api.application.port.in.vehicle.type.FindAllVehicleTypeUseCase.FindAllVehicleTypeQuery;
import mike.wolf.zygl.api.application.port.in.vehicle.type.FindByIdVehicleTypeUseCase.FindByIdVehicleTypeQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

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

}
