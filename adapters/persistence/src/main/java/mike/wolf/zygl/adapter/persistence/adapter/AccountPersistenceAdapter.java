package mike.wolf.zygl.adapter.persistence.adapter;

import javax.persistence.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

import lombok.RequiredArgsConstructor;
import mike.wolf.zygl.adapter.persistence.entities.AccountJpaEntity;
import mike.wolf.zygl.adapter.persistence.entities.ActivityJpaEntity;
import mike.wolf.zygl.adapter.persistence.mappers.AccountMapper;
import mike.wolf.zygl.adapter.persistence.repositories.AccountRepository;
import mike.wolf.zygl.adapter.persistence.repositories.ActivityRepository;
import mike.wolf.zygl.application.port.out.LoadAccountPort;
import mike.wolf.zygl.application.port.out.UpdateAccountStatePort;
import mike.wolf.zygl.common.PersistenceAdapter;
import mike.wolf.zygl.domain.Account;
import mike.wolf.zygl.domain.Account.AccountId;

import mike.wolf.zygl.domain.Activity;

@RequiredArgsConstructor
@PersistenceAdapter
class AccountPersistenceAdapter implements
		LoadAccountPort,
		UpdateAccountStatePort {

	private final AccountRepository accountRepository;
	private final ActivityRepository activityRepository;
	private final AccountMapper accountMapper;

	@Override
	public Account loadAccount(
					AccountId accountId,
					LocalDateTime baselineDate) {

		AccountJpaEntity account =
				accountRepository.findById(accountId.getValue())
						.orElseThrow(EntityNotFoundException::new);

		List<ActivityJpaEntity> activities =
				activityRepository.findByOwnerSince(
						accountId.getValue(),
						baselineDate);

		Long withdrawalBalance = orZero(activityRepository
				.getWithdrawalBalanceUntil(
						accountId.getValue(),
						baselineDate));

		Long depositBalance = orZero(activityRepository
				.getDepositBalanceUntil(
						accountId.getValue(),
						baselineDate));

		return accountMapper.mapToDomainEntity(
				account,
				activities,
				withdrawalBalance,
				depositBalance);

	}

	private Long orZero(Long value){
		return value == null ? 0L : value;
	}


	@Override
	public void updateActivities(Account account) {
		for (Activity activity : account.getActivityWindow().getActivities()) {
			if (activity.getId() == null) {
				activityRepository.save(accountMapper.mapToJpaEntity(activity));
			}
		}
	}

}
