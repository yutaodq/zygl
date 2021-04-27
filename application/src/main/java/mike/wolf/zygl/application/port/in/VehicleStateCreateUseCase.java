package mike.wolf.zygl.application.port.in;

import lombok.EqualsAndHashCode;
import lombok.Value;

import mike.wolf.zygl.domain.VehicleState;
import mike.wolf.zygl.domain.VehicleState.VehicleStateId;

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
            this.vehicleStateId = new VehicleStateId(vehicleStateId);
            this.name = name;
            this.description = description;
        }
    }

}
