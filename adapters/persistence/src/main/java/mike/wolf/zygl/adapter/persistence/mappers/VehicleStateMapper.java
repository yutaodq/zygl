/*
 * Copyright 2020 Yassine AZIMANI
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mike.wolf.zygl.adapter.persistence.mappers;


import mike.wolf.zygl.adapter.persistence.entities.VehicleStateJpaEntity;
import mike.wolf.zygl.application.model.VehicleStateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleStateMapper {

    VehicleStateMapper INSTANCE = Mappers.getMapper(VehicleStateMapper.class);

//    @Mapping(target = "quantityOrdered", ignore = true)
    VehicleStateDTO toDto(VehicleStateJpaEntity vehicleStateJpaEntity);

    VehicleStateJpaEntity toEntity(VehicleStateDTO vehicleStateDTO);

}// ProductMapper
