package mike.wolf.zygl.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.adapter.persistence.entities.VehicleStateJpaEntity;
import mike.wolf.zygl.adapter.persistence.repositories.VehicleStateRepository;
import mike.wolf.zygl.application.exceptions.TransactionException;
import mike.wolf.zygl.application.model.VehicleStateDTO;
import mike.wolf.zygl.application.port.out.VehicleStateQueryAllPort;
import mike.wolf.zygl.common.PersistenceAdapter;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class VehicleStatePersistenceAdapter implements VehicleStateQueryAllPort {
    private final VehicleStateRepository vehicleStateRepository ;
    @Override
    public List<VehicleStateDTO> findAllVehicleStates() {
        return null;
//        return vehicleStateRepository.findAll();
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
