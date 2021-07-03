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
            @Mapping(source = "vehicleJpaEntity.vehicleState.id", target = "stateId"),
            @Mapping(source = "vehicleJpaEntity.vehicleState.name", target = "stateName"),

            @Mapping(source = "vehicleJpaEntity.vehicleType.id", target = "typeId"),
            @Mapping(source = "vehicleJpaEntity.vehicleType.name", target = "typeName"),

            @Mapping(source = "vehicleJpaEntity.vehicleStructure.id", target = "stId"),
            @Mapping(source = "vehicleJpaEntity.vehicleStructure.cc", target = "stCc", defaultValue = "0"),
            @Mapping(source = "vehicleJpaEntity.vehicleStructure.ck", target = "stCk"),
            @Mapping(source = "vehicleJpaEntity.vehicleStructure.cg", target = "stCg"),
            @Mapping(source = "vehicleJpaEntity.vehicleStructure.zj", target = "stZj"),
            @Mapping(source = "vehicleJpaEntity.vehicleStructure.qlj", target = "stQlj"),
            @Mapping(source = "vehicleJpaEntity.vehicleStructure.hlj", target = "stHlj"),
            @Mapping(source = "vehicleJpaEntity.vehicleStructure.qdxs", target = "stQdxs"),
            @Mapping(source = "vehicleJpaEntity.vehicleStructure.fxpwz", target = "stFxpwz"),
            @Mapping(source = "vehicleJpaEntity.vehicleStructure.bsqxs", target = "stBsqxs"),

            @Mapping(source = "vehicleJpaEntity.vehicleParameter.id", target = "paId"),
            @Mapping(source = "vehicleJpaEntity.vehicleParameter.zczbzl", target = "paZczbzl"),
            @Mapping(source = "vehicleJpaEntity.vehicleParameter.zdzzzl", target = "paZdzzzl"),
            @Mapping(source = "vehicleJpaEntity.vehicleParameter.rylx", target = "paRylx"),
            @Mapping(source = "vehicleJpaEntity.vehicleParameter.pjyh", target = "paPjyh"),
            @Mapping(source = "vehicleJpaEntity.vehicleParameter.edgl", target = "paEdgl"),
            @Mapping(source = "vehicleJpaEntity.vehicleParameter.zdnj", target = "paZdnj"),
            @Mapping(source = "vehicleJpaEntity.vehicleParameter.zxzwbj", target = "paZxzwbj"),
            @Mapping(source = "vehicleJpaEntity.vehicleParameter.zgcs", target = "paZgcs"),

            @Mapping(source = "vehicleJpaEntity.vehicleSpecial.id", target = "spId"),
            @Mapping(source = "vehicleJpaEntity.vehicleSpecial.zdqzl", target = "spZdqzl"),
            @Mapping(source = "vehicleJpaEntity.vehicleSpecial.gjbj", target = "spGjbj"),
            @Mapping(source = "vehicleJpaEntity.vehicleSpecial.zb", target = "spZb"),
            @Mapping(source = "vehicleJpaEntity.vehicleSpecial.zbc", target = "spZbc"),
            @Mapping(source = "vehicleJpaEntity.vehicleSpecial.fbc", target = "spFbc"),
            @Mapping(source = "vehicleJpaEntity.vehicleSpecial.fdjxh", target = "spFdjxh"),
            @Mapping(source = "vehicleJpaEntity.vehicleSpecial.edgl", target = "spEdgl"),
            @Mapping(source = "vehicleJpaEntity.vehicleSpecial.zdnj", target = "spZdnj"),
            @Mapping(source = "vehicleJpaEntity.vehicleSpecial.zgzs", target = "spZgzs"),
            @Mapping(source = "vehicleJpaEntity.vehicleSpecial.rylx", target = "spRylx"),
            @Mapping(source = "vehicleJpaEntity.vehicleSpecial.pjyh", target = "spPjyh"),
            @Mapping(source = "vehicleJpaEntity.vehicleSpecial.glxh", target = "spGlxh"),
            @Mapping(source = "vehicleJpaEntity.vehicleSpecial.ysjxh", target = "spYsjxh"),
            @Mapping(source = "vehicleJpaEntity.vehicleSpecial.bxh", target = "spBxh"),
            @Mapping(source = "vehicleJpaEntity.vehicleSpecial.csyq", target = "spCsyq"),
            @Mapping(source = "vehicleJpaEntity.vehicleSpecial.dr", target = "spDr"),
            @Mapping(source = "vehicleJpaEntity.vehicleSpecial.bsqxs", target = "spBsqxs"),

    })
    VehicleDTO toDto(VehicleJpaEntity vehicleJpaEntity);

    VehicleJpaEntity toEntity(VehicleDTO vehicleDTO);

}
