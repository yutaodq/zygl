package mike.wolf.zygl.application.port.out;

import java.time.LocalDateTime;

import mike.wolf.zygl.domain.Account;
import mike.wolf.zygl.domain.Account.AccountId;

public interface LoadAccountPort {

	Account loadAccount(AccountId accountId, LocalDateTime baselineDate);
}
