package mike.wolf.zygl.api.application.port.in.vehicle.vehicle;

import lombok.Builder;
import lombok.Value;
import mike.wolf.zygl.api.domain.vehicle.type.TypeName;
import mike.wolf.zygl.api.domain.vehicle.vehicle.Parameter;
import mike.wolf.zygl.api.domain.vehicle.vehicle.Special;
import mike.wolf.zygl.api.domain.vehicle.vehicle.Structure;
import mike.wolf.zygl.api.domain.vehicle.vehicle.VehicleId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Value
@Builder()
public class VehicleCreateEvent {
    @NotNull(message = "车辆状态聚合标识对象不能为�?")
    @TargetAggregateIdentifier
    private VehicleId vehicleId;

    @NotNull(message = "状态名称对象不能为?")
    String name;  //车辆名称
    String ggxh;  //规格型号
    @NotNull(message = "状态名称对象不能为?")
    String pz;  //牌照号
    String nbpz;  //内部牌照号
    String sccj;  //生产厂家
    Date ccrq;  //出厂日期
    Date tcrq;  //投产日期
    BigDecimal yz;  //车辆原值
    String csys;  //车身颜色
    String fdjxh;  //发动机型号
    String fdjbh;  //发动机编号
    String dpxh;  //底盘型号
    String dpbh;  //底盘编号
    String description; // 备注
    Structure structure;
    Parameter parameter;
    Special special;

}
