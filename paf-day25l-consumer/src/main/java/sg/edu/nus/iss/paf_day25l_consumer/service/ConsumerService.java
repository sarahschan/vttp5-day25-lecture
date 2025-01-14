package sg.edu.nus.iss.paf_day25l_consumer.service;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf_day25l_consumer.model.Todo;

@Service
public class ConsumerService {
    
    public void handleMessage(Todo todo) {
        System.out.println(todo);
    }
}
