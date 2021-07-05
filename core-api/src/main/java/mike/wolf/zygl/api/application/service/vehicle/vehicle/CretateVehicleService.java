package mike.wolf.zygl.api.application.service.vehicle.vehicle;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.api.application.model.VehicleDTO;
import mike.wolf.zygl.api.application.port.in.vehicle.vehicle.CreateVehicleUseCase;
import mike.wolf.zygl.api.domain.vehicle.vehicle.Parameter;
import mike.wolf.zygl.api.domain.vehicle.vehicle.Special;
import mike.wolf.zygl.api.domain.vehicle.vehicle.Structure;
import mike.wolf.zygl.api.domain.vehicle.vehicle.VehicleId;
import mike.wolf.zygl.common.UseCase;
import org.axonframework.commandhandling.gateway.CommandGateway;

@RequiredArgsConstructor
@UseCase
public class CretateVehicleService implements CreateVehicleUseCase {
    private final CommandGateway commandGateway;

    @Override
    public void createVehicle(CreateVehicleCommand command) {
        commandGateway.sendAndWait(command);
    }
    @Override
    public void createVehicle(VehicleDTO vehicleDTO) {
        commandGateway.sendAndWait(createVehicleCommandInstance(vehicleDTO));
    }
    private CreateVehicleUseCase.CreateVehicleCommand createVehicleCommandInstance(final VehicleDTO vehicleDTO) {
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

}
