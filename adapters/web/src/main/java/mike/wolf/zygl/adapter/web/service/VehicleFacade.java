package mike.wolf.zygl.adapter.web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.web.model.FormVehicleDTO;
import mike.wolf.zygl.api.application.model.VehicleDTO;

import mike.wolf.zygl.api.application.port.in.vehicle.vehicle.*;
import mike.wolf.zygl.api.domain.vehicle.vehicle.Parameter;
import mike.wolf.zygl.api.domain.vehicle.vehicle.Special;
import mike.wolf.zygl.api.domain.vehicle.vehicle.Structure;
import mike.wolf.zygl.api.domain.vehicle.vehicle.VehicleId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleFacade {

    private final FindAllVehicleUseCase findAllVehicleUseCase;
    //    private final FindByNameVehicleUseCase findByNameVehicleUseCase;
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
//    public CompletableFuture<ResponseEntity<List<VehicleDTO>>> findByName() {
//        return findByNameVehicleUseCase.findAll();
//    }

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
    private Structure structureInstance(final VehicleDTO vehicleDTO) {
        return Structure.builder()
                .cc(vehicleDTO.getStCc())
                .ck(vehicleDTO.getStCk())
                .cg(vehicleDTO.getStCg())
                .zj(vehicleDTO.getStZj())
                .qlj(vehicleDTO.getStQlj())
                .hlj(vehicleDTO.getStHlj())
                .qdxs(vehicleDTO.getStQdxs())
                .fxpwz(vehicleDTO.getStFxpwz())
                .bsqxs(vehicleDTO.getStBsqxs())
                .build();
    }

    private Parameter parameterInstance(final VehicleDTO vehicleDTO) {
        return Parameter.builder()
                .zczbzl(vehicleDTO.getPaZczbzl())
                .zdzzzl(vehicleDTO.getPaZdzzzl())
                .rylx(vehicleDTO.getPaRylx())
                .pjyh(vehicleDTO.getPaPjyh())
                .edgl(vehicleDTO.getPaEdgl())
                .zdnj(vehicleDTO.getPaZdnj())
                .zxzwbj(vehicleDTO.getPaZxzwbj())
                .zgcs(vehicleDTO.getPaZgcs())
                .build();
    }

    private Special specialInstance(final VehicleDTO vehicleDTO) {
        return Special.builder()
                .zdqzl(vehicleDTO.getSpZdqzl())
                .gjbj(vehicleDTO.getSpGjbj())
                .zb(vehicleDTO.getSpZb())
                .zbc(vehicleDTO.getSpZbc())
                .fbc(vehicleDTO.getSpFbc())
                .fdjxh(vehicleDTO.getSpFdjxh())
                .edgl(vehicleDTO.getSpEdgl())
                .zdnj(vehicleDTO.getSpZdnj())
                .zgzs(vehicleDTO.getSpZgzs())
                .rylx(vehicleDTO.getSpRylx())
                .pjyh(vehicleDTO.getSpPjyh())
                .glxh(vehicleDTO.getSpGlxh())
                .ysjxh(vehicleDTO.getSpYsjxh())
                .bxh(vehicleDTO.getSpBxh())
                .csyq(vehicleDTO.getSpCsyq())
                .dr(vehicleDTO.getSpDr())
                .bsqxs(vehicleDTO.getSpBsqxs())
                .build();
    }


/*
    public void create(FormVehicleDTO formVehicleDTO)
            throws URISyntaxException {
        log.info("VehicleFacade REST createVehicle : {}", formVehicleDTO.getName());
        createVehicleUseCase.createVehicle(this.createVehicleCommandInstance(formVehicleDTO));
    }

 */
    public void create(VehicleDTO vehicleDTO)
            throws URISyntaxException {
        log.info("VehicleFacade REST createVehicle : {}", vehicleDTO.getName());
        createVehicleUseCase.createVehicle(this.createVehicleCommandInstance(vehicleDTO));
    }
    private CreateVehicleUseCase.CreateVehicleCommand createVehicleCommandInstance(final VehicleDTO vehicleDTO) {
//        VehicleId id = VehicleId.create(vehicleDTO.getId());
        return CreateVehicleUseCase.CreateVehicleCommand
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
                .structure(this.structureInstance(vehicleDTO))
                .parameter(this.parameterInstance(vehicleDTO))
                .special(this.specialInstance(vehicleDTO))
                .build();
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
