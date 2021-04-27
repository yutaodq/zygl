package mike.wolf.zygl.api.vehicle.state;

import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkArgument;

import java.io.Serializable;

@Getter
@Slf4j
@EqualsAndHashCode
@NoArgsConstructor
public final class StateName implements Serializable {
    private String name;

    private StateName(String name) {
        log.info("新建：StateName");
        setName(name);
    }

    private void setName(String name) {
        this.name = checkNotNull(name, "车辆状态名称不能是null！");
        checkArgument(!this.name.trim().isEmpty(), "请您录入车辆状态名称！");
    }
    public static StateName create(String name) {
        return new StateName(name);
    }
    public StateName changeStateName(String name) {
        return create(name);
    }
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("工具名称：", name).toString();
    }

}
