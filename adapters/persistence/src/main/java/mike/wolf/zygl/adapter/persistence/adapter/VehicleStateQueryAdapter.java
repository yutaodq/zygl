package mike.wolf.zygl.adapter.persistence.adapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mike.wolf.zygl.adapter.persistence.entities.VehicleStateJpaEntity;
import mike.wolf.zygl.adapter.persistence.mappers.VehicleStateMapper;
import mike.wolf.zygl.adapter.persistence.repositories.VehicleStateRepository;
import mike.wolf.zygl.application.exceptions.TransactionException;
import mike.wolf.zygl.application.model.VehicleStateDTO;
import mike.wolf.zygl.application.port.out.VehicleStateQueryPort;
import mike.wolf.zygl.common.PersistenceAdapter;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@PersistenceAdapter
@Slf4j
public class VehicleStateQueryAdapter implements VehicleStateQueryPort {
    private final VehicleStateRepository vehicleStateRepository;

    @Override
    public List<VehicleStateDTO> findAllVehicleStates() {
        return vehicleStateRepository.findAll().stream()
                .map(vehicleStateJpaEntity ->
                        VehicleStateMapper.INSTANCE.toDto(vehicleStateJpaEntity)
                ).collect(Collectors.toList());
    }

    @Override
    public Optional<VehicleStateDTO> findById(String id) {
        Optional<VehicleStateJpaEntity> vehicleState = vehicleStateRepository.findById(id);
        return vehicleState.map(vehicleStateJpaEntity -> {
                    return VehicleStateMapper.INSTANCE.toDto(vehicleStateJpaEntity);
                }
        );
    }

    @Override
    public boolean existsByName(String name) {
        return vehicleStateRepository.existsByName(name);
    }

    @Override
    public List<VehicleStateDTO> findByName(String name) {
        log.info("VehicleStateQueryAdapter： List<VehicleStateDTO> findByName(String name)");
        return vehicleStateRepository.findByName(name).stream()
                .map(vehicleStateJpaEntity ->
                        VehicleStateMapper.INSTANCE.toDto(vehicleStateJpaEntity)
                ).collect(Collectors.toList());
    }


}

public class GiftCard {
    @AggregateIdentifier
    private String id;
    private int remainingValue;

    @CommandHandler
    public GiftCard(IssueCardCommand cmd) {
        apply(new CardIssuedEvent(cmd.getCardId(), cmd.getAmount()));
    }

    @CommandHandler
    public void handle(RedeemCardCommand cmd) {
        if (cmd.getAmount() <= 0) {
            throw new IllegalArgumentException("amount <= 0");
        }
        if (cmd.getAmount() > remainingValue) {
            throw new IllegalStateException("amount > remaining value");
        }
        apply(new CardRedeemedEvent(id, cmd.getTransactionId(), cmd.getAmount()));
    }

// omitted event sourcing handlers

}

GiftCard句柄的Command对象IssueCardCommand和reviecardcommand具有以下格式：

        import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class IssueCardCommand {
    @TargetAggregateIdentifier
    private final String cardId;

    private final Integer amount;

    public IssueCardCommand(String cardId, Integer amount) {
        this.cardId = cardId;
        this.amount = amount;
    }
}

public class RedeemCardCommand {
    @TargetAggregateIdentifier
    private final String cardId;
    private final String transactionId;
    private final Integer amount;

    public RedeemCardCommand(String cardId, String transactionId, Integer amount) {
        this.cardId = cardId;
        this.transactionId = transactionId;
        this.amount = amount;
    }
}