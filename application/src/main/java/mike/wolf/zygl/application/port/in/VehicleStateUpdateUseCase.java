package mike.wolf.zygl.application.port.in;

import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotNull;

public interface VehicleStateUpdateUseCase {
    void update(UpdateVehicleStateCommand command);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class UpdateVehicleStateCommand  {

        @NotNull
        private final String id;
        private final String description;

        public UpdateVehicleStateCommand(
                String id,
                String description
        ) {
            this.id = id;
            this.description = description;

        }
    }

}
