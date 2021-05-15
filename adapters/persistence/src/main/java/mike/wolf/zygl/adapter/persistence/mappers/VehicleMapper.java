package mike.wolf.zygl.adapter.persistence.mappers;

import mike.wolf.zygl.adapter.persistence.entities.VehicleJpaEntity;
import mike.wolf.zygl.api.application.model.VehicleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleMapper {
    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

    @Mappings({
            @Mapping(source = "vehicleJpaEntity.vehicleState.name", target = "stateName"),
            @Mapping(source = "vehicleJpaEntity.vehicleType.name", target = "typeName")
    })
    VehicleDTO toDto(VehicleJpaEntity vehicleJpaEntity);

    VehicleJpaEntity toEntity(VehicleDTO vehicleDTO);

}
