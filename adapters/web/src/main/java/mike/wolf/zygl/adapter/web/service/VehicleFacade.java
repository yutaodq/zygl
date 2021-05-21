package mike.wolf.zygl.adapter.web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.web.model.FormVehicleDTO;
import mike.wolf.zygl.api.application.model.VehicleDTO;

import mike.wolf.zygl.api.application.port.in.vehicle.vehicle.*;
import mike.wolf.zygl.api.domain.vehicle.vehicle.VehicleId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleFacade {

    private final FindAllVehicleUseCase findAllVehicleUseCase;
    private final FindByIdVehicleUseCase findByIdVehicleUseCase;
        private final ExistsByPzVehicleUseCase existsByPzVehicleUseCase;
    private final ExistsByNbpzVehicleUseCase existsByNbpzVehicleUseCase;

    private final CreateVehicleUseCase createVehicleUseCase;
    //    private final DeleteVehicleUseCase deleteVehicleUseCase;
//    private final UpdateVehicleUseCase updateVehicleUseCase;
//    private final UpdateVehicleNameUseCase updateVehicleNameUseCase;

    /*
    query
     */
    public CompletableFuture<ResponseEntity<List<VehicleDTO>>> findAll() {
        return findAllVehicleUseCase.findAll();
    }

    public CompletableFuture<ResponseEntity<VehicleDTO>> findById(String id) {
        return findByIdVehicleUseCase.findById(id);

    }

    public CompletableFuture<Boolean> existsByPz(String pz) {
        return existsByPzVehicleUseCase.existsByPz(pz);
    }
    public CompletableFuture<Boolean> existsByNbpz(String nbpz) {
        return existsByNbpzVehicleUseCase.existsByNbpz(nbpz);
    }

/*
command
 */
//    public void deleteVehicle(String id) {
//         deleteVehicleUseCase.deleteVehicle(id);
//    }

    public void create(VehicleDTO vehicleDTO)
            throws URISyntaxException {
        log.info("VehicleFacade REST createVehicle : {}", vehicleDTO.getName());

        CreateVehicleUseCase.CreateVehicleCommand command = CreateVehicleUseCase.CreateVehicleCommand
                .builder()
                .vehicleId(VehicleId.create(vehicleDTO.getId()))
                .name(vehicleDTO.getName())
                .ggxh(vehicleDTO.getGgxh())  //规格型号
                .pz(vehicleDTO.getPz())  //牌照号
                .nbpz(vehicleDTO.getNbpz())  //内部牌照号
                .sccj(vehicleDTO.getSccj())  //生产厂家
                .ccrq(vehicleDTO.getCcrq())  //出厂日期
                .tcrq(vehicleDTO.getTcrq())  //投产日期
                .yz(vehicleDTO.getYz())  //车辆原值
                .csys(vehicleDTO.getCsys())  //车身颜色
                .fdjxh(vehicleDTO.getFdjxh())  //发动机型号
                .fdjbh(vehicleDTO.getFdjbh())  //发动机编号
                .dpxh(vehicleDTO.getDpxh())  //底盘型号
                .dpbh(vehicleDTO.getDpbh())  //底盘编号
                .description(vehicleDTO.getDescription())
                .build();
        createVehicleUseCase.createVehicle(command);
    }

//    public void updateVehicle(FormVehicleDTO dto) {
//        String updateType = dto.getUpdateType();
//        switch (updateType) {
//            case "updateName":
//                this.updateName(dto);
//                break;
//            default:
//                this.updateDefault(dto);
//
//        }
//    }
//
//    private void updateDefault(FormVehicleDTO dto) {
//        UpdateVehicleCommand command = UpdateVehicleCommand
//                .builder()
//                .vehicleId(VehicleId.create(dto.getId()))
//                .description(dto.getDescription())
//                .build();
//        updateVehicleUseCase.update(command);
//    }
//
//    private void updateName(FormVehicleDTO dto) {
//        UpdateVehicleNameCommand command = UpdateVehicleNameCommand
//                .builder()
//                .vehicleId(VehicleId.create(dto.getId()))
//                .typeName(TypeName.create(dto.getName()))
//                .build();
//        updateVehicleNameUseCase.updateName(command);
//
//    }
}
