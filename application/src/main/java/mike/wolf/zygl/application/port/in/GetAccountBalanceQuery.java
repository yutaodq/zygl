package mike.wolf.zygl.application.port.in;

import mike.wolf.zygl.domain.Account.AccountId;
import mike.wolf.zygl.domain.Money;

public interface GetAccountBalanceQuery {

	Money getAccountBalance(AccountId accountId);

}
