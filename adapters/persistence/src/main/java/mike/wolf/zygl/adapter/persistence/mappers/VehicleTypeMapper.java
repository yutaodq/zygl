package mike.wolf.zygl.adapter.persistence.mappers;

import mike.wolf.zygl.adapter.persistence.entities.VehicleTypeJpaEntity;
import mike.wolf.zygl.api.application.model.VehicleTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleTypeMapper {
    VehicleTypeMapper INSTANCE = Mappers.getMapper(VehicleTypeMapper.class);

    //    @Mapping(target = "quantityOrdered", ignore = true)
    VehicleTypeDTO toDto(VehicleTypeJpaEntity vehicleTypeJpaEntity);

    VehicleTypeJpaEntity toEntity(VehicleTypeDTO vehicleTypeDTO);

}
