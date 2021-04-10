package mike.wolf.zygl.application.port.out;

public interface VehicleStateCommPort {
    void create(
            String id,
            String vehicleStateId,
            String name,
            String description
    );
}
