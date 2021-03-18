package mike.wolf.zygl.application.port.in;

import lombok.EqualsAndHashCode;
import lombok.Value;

import mike.wolf.zygl.common.SelfValidating;
import mike.wolf.zygl.domain.Account.AccountId;
import mike.wolf.zygl.domain.Money;

import javax.validation.constraints.NotNull;

public interface SendMoneyUseCase {

	boolean sendMoney(SendMoneyCommand command);

	@Value
	@EqualsAndHashCode(callSuper = false)
	class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {

		@NotNull
		private final AccountId sourceAccountId;

		@NotNull
		private final AccountId targetAccountId;

		@NotNull
		private final Money money;

		public SendMoneyCommand(
				AccountId sourceAccountId,
				AccountId targetAccountId,
				Money money) {
			this.sourceAccountId = sourceAccountId;
			this.targetAccountId = targetAccountId;
			this.money = money;
			this.validateSelf();
		}
	}

}
