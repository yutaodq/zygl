package mike.wolf.zygl.application.port.out;

public interface VehicleStateCommandPort {
    void create(
            String id,
            String vehicleStateId,
            String name,
            String description
    );

    void delete(
            String id
    );
    void update(
            String id,
            String description
    );

}
