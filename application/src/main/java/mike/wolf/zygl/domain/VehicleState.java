package mike.wolf.zygl.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.context.annotation.Profile;
import org.axonframework.spring.stereotype.Aggregate;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Aggregate
@Profile("command")
public class VehicleState {

    @AggregateIdentifier
    private final VehicleStateId id;
    private final String name;  //状态名称
    private final String description; // 备注

    @CommandHandler
    public VehicleState(IssueCmd cmd) {
        logger.debug("handling {}", cmd);
        if (cmd.getAmount() <= 0) {
            throw new IllegalArgumentException("amount <= 0");
        }
        apply(new IssuedEvt(cmd.getId(), cmd.getAmount()));
    }

    @Value
    public static class VehicleStateId {
        private String value;
    }

}
