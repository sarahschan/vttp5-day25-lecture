package sg.edu.nus.iss.paf_day25l_consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {
    
    @Value("${redis.topic1}")
    private String redisTopic;

    
}
