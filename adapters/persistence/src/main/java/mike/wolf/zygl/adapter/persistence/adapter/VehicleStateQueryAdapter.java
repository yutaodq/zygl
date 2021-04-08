package mike.wolf.zygl.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.adapter.persistence.entities.VehicleStateJpaEntity;
import mike.wolf.zygl.adapter.persistence.mappers.VehicleStateMapper;
import mike.wolf.zygl.adapter.persistence.repositories.VehicleStateRepository;
import mike.wolf.zygl.application.exceptions.TransactionException;
import mike.wolf.zygl.application.model.VehicleStateDTO;
import mike.wolf.zygl.application.port.out.VehicleStateQueryPort;
import mike.wolf.zygl.common.PersistenceAdapter;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@PersistenceAdapter
public class VehicleStateQueryAdapter implements VehicleStateQueryPort {
    private final VehicleStateRepository vehicleStateRepository;

    @Override
    public List<VehicleStateDTO> findAllVehicleStates() {
        return vehicleStateRepository.findAll().stream()
                .map(vehicleStateJpaEntity ->
                        VehicleStateMapper.INSTANCE.toDto(vehicleStateJpaEntity)
                ).collect(Collectors.toList());
    }

    @Override
    public Optional<VehicleStateDTO> findById(String id) {
        Optional<VehicleStateJpaEntity> vehicleState = vehicleStateRepository.findById(id);
        return vehicleState.map(vehicleStateJpaEntity -> {
                    return VehicleStateMapper.INSTANCE.toDto(vehicleStateJpaEntity);
                }
        );
    }

    @Override
    public boolean existsByName(String name) {
        return vehicleStateRepository.existsByName(name);
    }


}
