package sg.edu.nus.iss.paf_day25l_producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf_day25l_producer.model.Student;
import sg.edu.nus.iss.paf_day25l_producer.model.Todo;

@Service
public class ProducerService {
    
    @Autowired @Qualifier("todo")
    RedisTemplate<String, Todo> redisTemplate;

    @Value("${redis.topic1}")
    private String topic1;

    @Value("${redis.topic2}")
    private String topic2;


    public void sendTodo(Todo todo){
        redisTemplate.convertAndSend(topic1, todo);
    }


    public void sendStudent(Student student) {
        redisTemplate.convertAndSend(topic2, student);
    }

}
