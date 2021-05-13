package mike.wolf.zygl.api.domain.vehicle.vehicle;


import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.common.domain.AbstractAggregateIdentifier;

import java.util.Objects;

@Slf4j
public final class VehicleId extends AbstractAggregateIdentifier {

    private VehicleId() {
        super();
    }

    private VehicleId(String identifier) {
        super(identifier);
    }

    public static VehicleId create() {
        return new VehicleId();
    }

    public static VehicleId create(String identifier) {
        return new VehicleId(identifier);
    }

    @Override
    public String toString() {
        return "VehicleId {" + "identifier='" + getIdentifier() + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final VehicleId other = (VehicleId) obj;
        return Objects.equals(this.getIdentifier(), other.getIdentifier());
    }

}
