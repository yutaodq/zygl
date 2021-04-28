package mike.wolf.zygl.application.port.in;

import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotNull;

public interface VehicleStateDeleteUseCase {
    void delete(DeleteVehicleStateCommand command);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class DeleteVehicleStateCommand  {

        @NotNull
        private final String id;

        public DeleteVehicleStateCommand(
                String id) {
            this.id = id;
        }
    }

}
