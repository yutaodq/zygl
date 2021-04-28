package mike.wolf.zygl.adapter.persistence.adapter;

import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.persistence.entities.VehicleStateJpaEntity;
import mike.wolf.zygl.adapter.persistence.mappers.VehicleStateMapper;
import mike.wolf.zygl.adapter.persistence.repositories.VehicleStateRepository;
import mike.wolf.zygl.api.vehicle.state.FindAllVehicleStateQuery;
import mike.wolf.zygl.api.vehicle.state.VehicleStateByIdQuery;
import mike.wolf.zygl.api.vehicle.state.VehicleStateCreateEvent;
import mike.wolf.zygl.application.model.VehicleStateDTO;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
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

    @EventHandler
    public void on(VehicleStateCreateEvent event) {
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
