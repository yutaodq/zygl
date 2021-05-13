package mike.wolf.zygl.api.domain.vehicle.vehicle;

import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Getter
@Slf4j
@EqualsAndHashCode
@NoArgsConstructor
public class VehicleNbpz implements Serializable {
    private String name;

    private VehicleNbpz(String name) {
        log.info("新建：TypeName");
        setName(name);
    }

    private void setName(String name) {
        this.name = checkNotNull(name, "车辆牌照不能是null！");
        checkArgument(!this.name.trim().isEmpty(), "请您录入车辆牌照！");
    }

    public static VehicleNbpz create(String name) {
        return new VehicleNbpz(name);
    }

    public VehicleNbpz changeTypeName(String name) {
        return create(name);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("车辆类型名称：", name).toString();
    }
}
