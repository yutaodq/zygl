package mike.wolf.zygl.adapter.persistence.repositories;

import mike.wolf.zygl.adapter.persistence.entities.ActivityJpaEntity;
import mike.wolf.zygl.adapter.persistence.entities.VehicleJpaEntity;
import mike.wolf.zygl.api.application.model.VehicleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface VehicleRepository extends JpaRepository<VehicleJpaEntity, String> {
    boolean existsByPz(String pz);
    boolean existsByNbpz(String nbpz);


    //    @Query("select vehicle from VehicleJpaEntity vehicle " )
//    List<VehicleJpaEntity> findAlld();

//    @Query("select vehicle.id as id," +
//            "vehicle.name as name," +
//            "vehicle.pz as pz," +
//            "vehicle.nbpz as nbpz," +
//            "vehicle.vehicleState.name as stateNme," +
//            "vehicle.vehicleType.name as typeNme" +
//            " from VehicleJpaEntity vehicle "
//    )
//List<VehicleDTO> findAlld();

//    @Query("select vehicle.id as id," +
//            "vehicle.name as name," +
//            "vehicle.pz as pz," +
//            "vehicle.nbpz as nbpz," +
//            "state.name as stateName," +
//            "type.name as typeName" +
//            " from VehicleJpaEntity vehicle " +
//            " left join fetch vehicle.vehicleState state" +
//            " left join fetch vehicle.vehicleType type")
//    List<VehicleDTO> findAlld();

}
