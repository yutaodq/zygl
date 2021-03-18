package mike.wolf.zygl;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "zygl")
public class IvmsConfigurationProperties {

  private long transferThreshold = Long.MAX_VALUE;

}
