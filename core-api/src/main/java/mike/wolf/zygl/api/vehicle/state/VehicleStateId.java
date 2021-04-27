package mike.wolf.zygl.api.vehicle.state;

import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.common.domain.AbstractAggregateIdentifier;

@Slf4j
public final class VehicleStateId extends AbstractAggregateIdentifier {

    private VehicleStateId() {
        super();
        log.info("新建：ProductId");
    }

    private VehicleStateId(String identifier) {
        super(identifier);
        log.info("新建：ProductId");
    }

    public static VehicleStateId create() {
        return new VehicleStateId();
    }

    public static VehicleStateId create(String identifier) {
        return new VehicleStateId(identifier);
    }

    @Override
    public String toString() {
        return "ProductId{" + "identifier='" + getIdentifier() + '\'' + '}';
    }
}
