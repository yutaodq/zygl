package mike.wolf.zygl.api.domain.vehicle.type;

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
public final class TypeName implements Serializable {
    private String name;

    private TypeName(String name) {
        log.info("新建：TypeName");
        setName(name);
    }

    private void setName(String name) {
        this.name = checkNotNull(name, "车辆类型名称不能是null！");
        checkArgument(!this.name.trim().isEmpty(), "请您录入车辆类型名称！");
    }
    public static TypeName create(String name) {
        return new TypeName(name);
    }
    public TypeName changeTypeName(String name) {
        return create(name);
    }
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("车辆类型名称：", name).toString();
    }

}
