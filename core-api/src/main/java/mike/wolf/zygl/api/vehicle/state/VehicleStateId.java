package mike.wolf.zygl.api.vehicle.state;

import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.common.domain.AbstractAggregateIdentifier;

import java.util.Objects;

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

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//        final VehicleStateId other = (VehicleStateId) obj;
//        return Objects.equals(this.getIdentifier(), other.getIdentifier());
//    }

}
