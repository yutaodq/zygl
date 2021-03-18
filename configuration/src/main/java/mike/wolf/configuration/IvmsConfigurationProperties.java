package mike.wolf.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "buckpal")
public class IvmsConfigurationProperties {

  private long transferThreshold = Long.MAX_VALUE;

}
