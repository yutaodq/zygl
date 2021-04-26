package mike.wolf.zygl.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.axonframework.config.EventProcessingConfigurer;

@Configuration
@Slf4j
public class AxonConfig {

    @Autowired
    public void configure(EventProcessingConfigurer configurer) {
//        将事件处理器默认设置为订阅事件处理器，而不是跟踪事件处理器
        configurer.usingTrackingEventProcessors();
    }

}
