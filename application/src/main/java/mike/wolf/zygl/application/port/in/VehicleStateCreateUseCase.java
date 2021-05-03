package mike.wolf.zygl.application.port.in;

import lombok.EqualsAndHashCode;
import lombok.Value;
import mike.wolf.zygl.api.domain.vehicle.state.VehicleStateId;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.constraints.NotNull;

public interface VehicleStateCreateUseCase {
    void create(CreateVehicleStateCommand command);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class CreateVehicleStateCommand  {

        @NotNull
        @TargetAggregateIdentifier
        private final VehicleStateId vehicleStateId;

        @NotNull
        private final String name;

        private final String description;

        public CreateVehicleStateCommand(
                String vehicleStateId,
                String name,
                String description) {
            this.vehicleStateId = VehicleStateId.create(vehicleStateId);
            this.name = name;
            this.description = description;
        }
    }

}
