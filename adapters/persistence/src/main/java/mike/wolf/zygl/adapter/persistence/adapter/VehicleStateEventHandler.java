package mike.wolf.zygl.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.persistence.entities.VehicleStateJpaEntity;
import mike.wolf.zygl.adapter.persistence.exception.DuplicatedNameException;
import mike.wolf.zygl.adapter.persistence.mappers.VehicleStateMapper;
import mike.wolf.zygl.adapter.persistence.repositories.VehicleStateRepository;
import mike.wolf.zygl.api.application.port.in.vehicle.state.*;
import mike.wolf.zygl.api.application.model.VehicleStateDTO;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleStateEventHandler {
    private final VehicleStateRepository vehicleStateRepository;

    @QueryHandler
    public List<VehicleStateDTO> find(final FindAllVehicleStateUseCase.FindAllVehicleStateQuery query) {
        return vehicleStateRepository.findAll().stream()
                .map(VehicleStateMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
     }
//    @QueryHandler
//    public List<BookBean> getBooks(GetBooksQuery query) {
//        return bookRepository.findByLibraryId(query.getLibraryId()).stream()
//                .map(e -> {
//                    BookBean book = new BookBean();
//                    book.setIsbn(e.getIsbn());
//                    book.setTitle(e.getTitle());
//                    return book;
//                }).collect(Collectors.toList());
//    }

    @QueryHandler
    public Optional<VehicleStateDTO> findById(final FindByIdVehicleStateUseCase.FindByIdVehicleStateQuery query) {
        String id = query.getVehicleStateId().getIdentifier();
       return  findById(id).map(VehicleStateMapper.INSTANCE::toDto);
//        Optional<VehicleStateJpaEntity> vehicleState = vehicleStateRepository.findById(query.getVehicleStateId().getIdentifier());
//        return vehicleState.map(VehicleStateMapper.INSTANCE::toDto);
    }

    private Optional<VehicleStateJpaEntity> findById(String id) {
        return  vehicleStateRepository.findById(id);
    }

    @QueryHandler
    public boolean existsByName( final ExistsByNameVehicleStateUseCase.ExistsByNameVehicleStateQuery query) {
        return vehicleStateRepository.existsByName(query.getStateName().getName());
    }

    @EventHandler
    public void on(final VehicleStateCreateEvent event) {
        log.info("VehicleStateEventHandler on(VehicleStateCreateEvent event) : {}", event.getVehicleStateId().getIdentifier());
        VehicleStateJpaEntity entity = VehicleStateJpaEntity.builder()
                .id(event.getVehicleStateId().getIdentifier())
                .name(event.getStateName().getName())
                .description(event.getDescription())
                .build();
        try {
//            vehicleStateRepository.save(entity).getId();
            vehicleStateRepository.save(entity);

        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new DuplicatedNameException(entity.getName());
        }

    }

    @EventHandler
    public void on(final VehicleStateDeleteEvent event) {
        log.info("删除车辆状态 : {}", event.getVehicleStateId().getIdentifier());
        vehicleStateRepository.deleteById(event.getVehicleStateId().getIdentifier());
    }

    @EventHandler
    public void on(final VehicleStateUpdateEvent event) {
        String id = event.getVehicleStateId().getIdentifier();
        VehicleStateJpaEntity vehicleState = findById(id).map(data -> {
            VehicleStateJpaEntity entity = data;
            entity.setDescription(event.getDescription());
            return entity;
        }).get();
        vehicleStateRepository.save(vehicleState);
    }

    @EventHandler
    public void on(final VehicleStateUpdateNameEvent event) {
        String id = event.getVehicleStateId().getIdentifier();
        VehicleStateJpaEntity vehicleState = findById(id).map(data -> {
            VehicleStateJpaEntity entity = data;
            entity.setName(event.getStateName().getName());
            return entity;
        }).get();
        vehicleStateRepository.save(vehicleState);
    }

}
