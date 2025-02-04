package sg.edu.nus.iss.paf_day25l_consumer.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import sg.edu.nus.iss.paf_day25l_consumer.model.Student;
import sg.edu.nus.iss.paf_day25l_consumer.model.Todo;
import sg.edu.nus.iss.paf_day25l_consumer.service.ConsumerService;

@Configuration
public class RedisConfig {
    
    @Value("${redis.topic1}")
    private String redisTopic1;

    @Value("${redis.topic2}")
    private String redisTopic2;


    @Bean("todo")
    RedisTemplate<String, Todo> redisTemplateTodo(RedisConnectionFactory redisConnectionFactory, Jackson2JsonRedisSerializer<Todo> serializer){
        
        RedisTemplate<String, Todo> redisTemplate = new RedisTemplate<>();
            redisTemplate.setConnectionFactory(redisConnectionFactory);
            redisTemplate.setDefaultSerializer(serializer);
            redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    @Bean
    public Jackson2JsonRedisSerializer<Todo> jackson2JsonRedisSerializerTodo(){
        return new Jackson2JsonRedisSerializer<>(Todo.class);
    }

    @Bean
    public RedisMessageListenerContainer listenerContainerTodo(@Qualifier("listenerAdapterTodo") MessageListenerAdapter messageListenerAdapter, RedisConnectionFactory redisConnectionFactory) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
            container.setConnectionFactory(redisConnectionFactory);
            container.addMessageListener(messageListenerAdapter, new PatternTopic(redisTopic1));

        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapterTodo(ConsumerService consumerService){

        MessageListenerAdapter adapter = new MessageListenerAdapter(consumerService, "handleTodoMessage");
            adapter.setSerializer(new Jackson2JsonRedisSerializer<>(Todo.class));

        return adapter;
    }



    @Bean("student")
    RedisTemplate<String, Student> redisTemplateStudent(RedisConnectionFactory redisConnectionFactory, Jackson2JsonRedisSerializer<Student> serializer) {
        
        RedisTemplate<String, Student> redisTemplate = new RedisTemplate<>();
            redisTemplate.setConnectionFactory(redisConnectionFactory);
            redisTemplate.setDefaultSerializer(serializer);
            redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    @Bean
    public Jackson2JsonRedisSerializer<Student> jackson2JsonRedisSerializerStudent(){
        return new Jackson2JsonRedisSerializer<>(Student.class);
    }

    @Bean
    public RedisMessageListenerContainer listenerContainerStudent(@Qualifier("listenerAdapterStudent") MessageListenerAdapter messageListenerAdapter, RedisConnectionFactory redisConnectionFactory) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
            container.setConnectionFactory(redisConnectionFactory);
            container.addMessageListener(messageListenerAdapter, new PatternTopic(redisTopic2));

        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapterStudent(ConsumerService consumerService){

        MessageListenerAdapter adapter = new MessageListenerAdapter(consumerService, "handleStudentMessage");
            adapter.setSerializer(new Jackson2JsonRedisSerializer<>(Student.class));

        return adapter;
    }


}
