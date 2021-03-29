package mike.wolf.zygl.adapter.web;


import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.application.port.in.SendMoneyUseCase;
import mike.wolf.zygl.application.port.in.SendMoneyUseCase.SendMoneyCommand;
import mike.wolf.zygl.common.WebAdapter;
import mike.wolf.zygl.domain.Account.AccountId;
import mike.wolf.zygl.domain.Money;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class SendMoneyController {

	private final SendMoneyUseCase sendMoneyUseCase;

	@PostMapping(path = "/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
	void sendMoney(
			@PathVariable("sourceAccountId") Long sourceAccountId,
			@PathVariable("targetAccountId") Long targetAccountId,
			@PathVariable("amount") Long amount) {

		SendMoneyCommand command = new SendMoneyCommand(
				new AccountId(sourceAccountId),
				new AccountId(targetAccountId),
				Money.of(amount));

		sendMoneyUseCase.sendMoney(command);
	}

}
