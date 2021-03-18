package mike.wolf.zygl.application.service;

import mike.wolf.zygl.application.port.out.AccountLock;
import mike.wolf.zygl.domain.Account.AccountId;
import org.springframework.stereotype.Component;

@Component
class NoOpAccountLock implements AccountLock {

	@Override
	public void lockAccount(AccountId accountId) {
		// do nothing
	}

	@Override
	public void releaseAccount(AccountId accountId) {
		// do nothing
	}

}
