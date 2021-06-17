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

    public void create(FormVehicleDTO formVehicleDTO)
            throws URISyntaxException {
        log.info("VehicleFacade REST createVehicle : {}", formVehicleDTO.getName());

        Structure structure = Structure.builder()
                .cc(formVehicleDTO.getStructure().getCc())
                .ck(formVehicleDTO.getStructure().getCk())
                .cg(formVehicleDTO.getStructure().getCg())
                .zj(formVehicleDTO.getStructure().getZj())
                .qlj(formVehicleDTO.getStructure().getQlj())
                .hlj(formVehicleDTO.getStructure().getHlj())
                .qdxs(formVehicleDTO.getStructure().getQdxs())
                .fxpwz(formVehicleDTO.getStructure().getFxpwz())
                .bsqxs(formVehicleDTO.getStructure().getBsqxs())
                .build();
        Parameter parameter = Parameter.builder()
                .zczbzl(formVehicleDTO.getParameter().getZczbzl())
                .zdzzzl(formVehicleDTO.getParameter().getZdzzzl())
                .rylx(formVehicleDTO.getParameter().getRylx())
                .pjyh(formVehicleDTO.getParameter().getPjyh())
                .edgl(formVehicleDTO.getParameter().getEdgl())
                .zdnj(formVehicleDTO.getParameter().getZdnj())
                .zxzwbj(formVehicleDTO.getParameter().getZxzwbj())
                .zgcs(formVehicleDTO.getParameter().getZgcs())
                .build();
        Special special = Special.builder()
                .zdqzl(formVehicleDTO.getSpecial().getZdqzl())
                .gjbj(formVehicleDTO.getSpecial().getGjbj())
                .zb(formVehicleDTO.getSpecial().getZb())
                .zbc(formVehicleDTO.getSpecial().getZbc())
                .fbc(formVehicleDTO.getSpecial().getFbc())
                .fdjxh(formVehicleDTO.getSpecial().getFdjxh())
                .edgl(formVehicleDTO.getSpecial().getEdgl())
                .zdnj(formVehicleDTO.getSpecial().getZdnj())
                .qdxs(formVehicleDTO.getSpecial().getQdxs())
                .rylx(formVehicleDTO.getSpecial().getRylx())
                .pjyh(formVehicleDTO.getSpecial().getPjyh())
                .glxh(formVehicleDTO.getSpecial().getGlxh())
                .ysjxh(formVehicleDTO.getSpecial().getYsjxh())
                .bxh(formVehicleDTO.getSpecial().getBxh())
                .csyq(formVehicleDTO.getSpecial().getCsyq())
                .dr(formVehicleDTO.getSpecial().getDr())
                .bsqxs(formVehicleDTO.getSpecial().getBsqxs())
                .build();
        CreateVehicleUseCase.CreateVehicleCommand command = CreateVehicleUseCase.CreateVehicleCommand
                .builder()
                .vehicleId(VehicleId.create())
                .name(formVehicleDTO.getName())
                .ggxh(formVehicleDTO.getGgxh())  //规格型号
                .pz(formVehicleDTO.getPz())  //牌照号
                .nbpz(formVehicleDTO.getNbpz())  //内部牌照号
                .sccj(formVehicleDTO.getSccj())  //生产厂家
                .ccrq(formVehicleDTO.getCcrq())  //出厂日期
                .tcrq(formVehicleDTO.getTcrq())  //投产日期
                .yz(formVehicleDTO.getYz())  //车辆原值
                .csys(formVehicleDTO.getCsys())  //车身颜色
                .fdjxh(formVehicleDTO.getFdjxh())  //发动机型号
                .fdjbh(formVehicleDTO.getFdjbh())  //发动机编号
                .dpxh(formVehicleDTO.getDpxh())  //底盘型号
                .dpbh(formVehicleDTO.getDpbh())  //底盘编号
                .description(formVehicleDTO.getDescription())
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
