package mike.wolf.zygl.application.service;

import java.time.LocalDateTime;


import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.application.port.in.GetAccountBalanceQuery;
import mike.wolf.zygl.application.port.out.LoadAccountPort;
import mike.wolf.zygl.domain.Account;
import mike.wolf.zygl.domain.Money;

@RequiredArgsConstructor
class GetAccountBalanceService implements GetAccountBalanceQuery {

	private final LoadAccountPort loadAccountPort;

	@Override
	public Money getAccountBalance(Account.AccountId accountId) {
		return loadAccountPort.loadAccount(accountId, LocalDateTime.now())
				.calculateBalance();
	}
}
