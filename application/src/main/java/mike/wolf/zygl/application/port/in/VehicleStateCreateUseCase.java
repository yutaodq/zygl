package mike.wolf.zygl.application.port.in;

import lombok.EqualsAndHashCode;
import lombok.Value;
import mike.wolf.zygl.common.SelfValidating;
import mike.wolf.zygl.domain.Account;
import mike.wolf.zygl.domain.Money;
import mike.wolf.zygl.domain.VehicleState;
import mike.wolf.zygl.domain.VehicleState.VehicleStateId;

import javax.validation.constraints.NotNull;

public interface VehicleStateCreateUseCase {
    void create(CreateVehicleStateCommand command);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class CreateVehicleStateCommand  {

        @NotNull
        private final String id;

        @NotNull
        private final VehicleStateId vehicleStateId;

        @NotNull
        private final String name;

        @NotNull
        private final String description;

        public CreateVehicleStateCommand(
                String id,
                String vehicleStateId,
                String name,
                String description) {
            this.id = id;
            this.vehicleStateId = new VehicleStateId(vehicleStateId);
            this.name = name;
            this.description = description;
        }
    }

}
