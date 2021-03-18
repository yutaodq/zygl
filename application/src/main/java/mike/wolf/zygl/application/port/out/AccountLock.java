package mike.wolf.zygl.application.port.out;


import mike.wolf.zygl.domain.Account;

public interface AccountLock {

	void lockAccount(Account.AccountId accountId);

	void releaseAccount(Account.AccountId accountId);

}
