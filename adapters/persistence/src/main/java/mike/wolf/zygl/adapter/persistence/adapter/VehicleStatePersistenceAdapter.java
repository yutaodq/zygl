package mike.wolf.zygl.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.adapter.persistence.entities.VehicleStateJpaEntity;
import mike.wolf.zygl.adapter.persistence.mappers.VehicleStateMapper;
import mike.wolf.zygl.adapter.persistence.repositories.VehicleStateRepository;
import mike.wolf.zygl.application.exceptions.TransactionException;
import mike.wolf.zygl.application.model.VehicleStateDTO;
import mike.wolf.zygl.application.port.out.VehicleStateQueryAllPort;
import mike.wolf.zygl.common.PersistenceAdapter;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@PersistenceAdapter
public class VehicleStatePersistenceAdapter implements VehicleStateQueryAllPort {
    private final VehicleStateRepository vehicleStateRepository ;
    @Override
    public List<VehicleStateDTO> findAllVehicleStates() {
        return vehicleStateRepository.findAll().stream()
                .map(vehicleStateJpaEntity -> {
                    return VehicleStateMapper.INSTANCE.toDto(vehicleStateJpaEntity);
                }).collect(Collectors.toList());
    }

    public List<VehicleStateJpaEntity> findAll() {
        return vehicleStateRepository.findAll();
    }


    @Override
    public void begin() {

    }

    @Override
    public void commit() throws TransactionException {

    }

    @Override
    public void rollback() {

    }
}
