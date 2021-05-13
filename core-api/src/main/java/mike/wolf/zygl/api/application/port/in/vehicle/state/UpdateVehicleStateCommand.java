//package mike.wolf.zygl.api.application.port.in.vehicle.state;
//
//import lombok.Builder;
//import lombok.Value;
//import mike.wolf.zygl.api.domain.vehicle.state.StateName;
//import mike.wolf.zygl.api.domain.vehicle.state.VehicleStateId;
//import org.axonframework.modelling.command.TargetAggregateIdentifier;
//
//import javax.validation.constraints.NotNull;
//@Builder()
//@Value
//
//public class UpdateVehicleStateCommand {
//
//    @NotNull(message = "工具标识对象不能为空")
//    @TargetAggregateIdentifier
//    VehicleStateId vehicleStateId;
//
//    String description; // 备注
//
//}
