package mike.wolf.zygl;

//import io.reflectoring.buckpal.application.service.MoneyTransferProperties;
//import io.reflectoring.buckpal.domain.Money;
import mike.wolf.zygl.application.service.MoneyTransferProperties;
import mike.wolf.zygl.domain.Money;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(IvmsConfigurationProperties.class)
public class IvmsConfiguration {

  /**
   * Adds a use-case-specific {@link MoneyTransferProperties} object to the application context. The properties
   * are read from the Spring-Boot-specific {@link IvmsConfigurationProperties} object.
   */
  @Bean
  public MoneyTransferProperties moneyTransferProperties(IvmsConfigurationProperties buckPalConfigurationProperties){
    return new MoneyTransferProperties(Money.of(buckPalConfigurationProperties.getTransferThreshold()));
  }

}
