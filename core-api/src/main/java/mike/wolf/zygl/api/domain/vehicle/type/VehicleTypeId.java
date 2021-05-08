package mike.wolf.zygl.api.domain.vehicle.type;


import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.common.domain.AbstractAggregateIdentifier;

import java.util.Objects;

@Slf4j
public final class VehicleTypeId extends AbstractAggregateIdentifier {

    private VehicleTypeId() {
        super();
        log.info("新建：ProductId");
    }

    private VehicleTypeId(String identifier) {
        super(identifier);
        log.info("新建：ProductId");
    }

    public static VehicleTypeId create() {
        return new VehicleTypeId();
    }

    public static VehicleTypeId create(String identifier) {
        return new VehicleTypeId(identifier);
    }

    @Override
    public String toString() {
        return "VehicleTypeId {" + "identifier='" + getIdentifier() + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final VehicleTypeId other = (VehicleTypeId) obj;
        return Objects.equals(this.getIdentifier(), other.getIdentifier());
    }

}
