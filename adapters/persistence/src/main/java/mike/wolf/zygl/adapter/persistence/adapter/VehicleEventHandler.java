package mike.wolf.zygl.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.persistence.entities.VehicleJpaEntity;
import mike.wolf.zygl.adapter.persistence.exception.DuplicatedNameException;
import mike.wolf.zygl.adapter.persistence.mappers.VehicleMapper;
import mike.wolf.zygl.adapter.persistence.repositories.VehicleRepository;
import mike.wolf.zygl.api.application.model.VehicleDTO;
import mike.wolf.zygl.api.application.port.in.vehicle.type.ExistsByNameVehicleTypeUseCase;
import mike.wolf.zygl.api.application.port.in.vehicle.vehicle.*;
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

    @QueryHandler
    public boolean existsByPz(final ExistsByPzVehicleUseCase.ExistsByPzQuery query) {
        return vehicleRepository.existsByPz(query.getPz());
    }

    @QueryHandler
    public boolean existsByNbpz(final ExistsByNbpzVehicleUseCase.ExistsByNbpzQuery query) {
        return vehicleRepository.existsByNbpz(query.getNbpz());
    }

    //    @QueryHandler
//    public boolean existsByName(final ExistsByNameVehicleQuery query) {
//        return vehicleRepository.existsByName(query.getTypeName().getName());
//    }
//
    /*
      Command
    */
    @EventHandler
    public void on(final VehicleCreateEvent event) {
        log.info("VehicleEventHandler on(VehicleCreateEvent event) : {}", event.getVehicleId().getIdentifier());
        VehicleJpaEntity entity = VehicleJpaEntity.builder()
                .id(event.getVehicleId().getIdentifier())
                .name(event.getName())
                .ggxh(event.getGgxh())  //规格型号
                .pz(event.getPz())  //牌照号
                .nbpz(event.getNbpz())  //内部牌照号
                .sccj(event.getSccj())  //生产厂家
                .ccrq(event.getCcrq())  //出厂日期
                .tcrq(event.getTcrq())  //投产日期
                .yz(event.getYz())  //车辆原值
                .csys(event.getCsys())  //车身颜色
                .fdjxh(event.getFdjxh())  //发动机型号
                .fdjbh(event.getFdjbh())  //发动机编号
                .dpxh(event.getDpxh())  //底盘型号
                .dpbh(event.getDpbh())  //底盘编号
                .description(event.getDescription())
                .build();
        try {
            vehicleRepository.save(entity);

        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new DuplicatedNameException(entity.getName());
        }

    }

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
