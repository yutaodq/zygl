package mike.wolf.zygl.adapter.persistence.mappers;

import java.util.ArrayList;
import java.util.List;

import mike.wolf.zygl.adapter.persistence.entities.AccountJpaEntity;
import mike.wolf.zygl.adapter.persistence.entities.ActivityJpaEntity;
import mike.wolf.zygl.domain.Account;
import mike.wolf.zygl.domain.Account.AccountId;
import mike.wolf.zygl.domain.Activity;
import mike.wolf.zygl.domain.ActivityWindow;
import mike.wolf.zygl.domain.Money;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

	public Account mapToDomainEntity(
			AccountJpaEntity account,
			List<ActivityJpaEntity> activities,
			Long withdrawalBalance,
			Long depositBalance) {

		Money baselineBalance = Money.subtract(
				Money.of(depositBalance),
				Money.of(withdrawalBalance));

		return Account.withId(
				new AccountId(account.getId()),
				baselineBalance,
				mapToActivityWindow(activities));

	}

	ActivityWindow mapToActivityWindow(List<ActivityJpaEntity> activities) {
		List<Activity> mappedActivities = new ArrayList<>();

		for (ActivityJpaEntity activity : activities) {
			mappedActivities.add(new Activity(
					new Activity.ActivityId(activity.getId()),
					new AccountId(activity.getOwnerAccountId()),
					new AccountId(activity.getSourceAccountId()),
					new AccountId(activity.getTargetAccountId()),
					activity.getTimestamp(),
					Money.of(activity.getAmount())));
		}

		return new ActivityWindow(mappedActivities);
	}

	public ActivityJpaEntity mapToJpaEntity(Activity activity) {
		return new ActivityJpaEntity(
				activity.getId() == null ? null : activity.getId().getValue(),
				activity.getTimestamp(),
				activity.getOwnerAccountId().getValue(),
				activity.getSourceAccountId().getValue(),
				activity.getTargetAccountId().getValue(),
				activity.getMoney().getAmount().longValue());
	}

}
