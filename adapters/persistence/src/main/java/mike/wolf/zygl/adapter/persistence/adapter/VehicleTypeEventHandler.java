package mike.wolf.zygl.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.persistence.mappers.VehicleTypeMapper;
import mike.wolf.zygl.adapter.persistence.repositories.VehicleTypeRepository;
import mike.wolf.zygl.api.application.model.VehicleTypeDTO;
import mike.wolf.zygl.api.application.port.in.vehicle.type.FindAllVehicleTypeUseCase.FindAllVehicleTypeQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleTypeEventHandler {
    private final VehicleTypeRepository vehicleTypeRepository;

    @QueryHandler
    public List<VehicleTypeDTO> find(final FindAllVehicleTypeQuery query) {
        return vehicleTypeRepository.findAll().stream()
                .map(VehicleTypeMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
