package mike.wolf.zygl.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class VehicleState {
    private final VehicleStateId id;
    private final String name;  //状态名称
    private final String description; // 备注

    @Value
    public static class VehicleStateId {
        private String value;
    }

}
