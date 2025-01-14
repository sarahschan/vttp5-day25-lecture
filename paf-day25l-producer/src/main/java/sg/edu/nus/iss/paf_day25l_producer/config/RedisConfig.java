package sg.edu.nus.iss.paf_day25l_producer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import sg.edu.nus.iss.paf_day25l_producer.model.Todo;

@Configuration
public class RedisConfig {
    
    @Bean("todo")
    RedisTemplate<String, Todo> redisTemplate(RedisConnectionFactory RedisConnectionFactory, Jackson2JsonRedisSerializer<Todo> serializer) {

        RedisTemplate<String, Todo> redisTemplate = new RedisTemplate<>();
            redisTemplate.setConnectionFactory(RedisConnectionFactory);
            redisTemplate.setDefaultSerializer(serializer);
            redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }


    @Bean
    public Jackson2JsonRedisSerializer<Todo> jackson2JsonRedisSerializer(){
        return new Jackson2JsonRedisSerializer<>(Todo.class);
    }
    
}
