package sg.edu.nus.iss.paf_day25l_consumer.service;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf_day25l_consumer.model.Student;
import sg.edu.nus.iss.paf_day25l_consumer.model.Todo;

@Service
public class ConsumerService {
    
    public void handleTodoMessage(Todo todo) {
        System.out.println(todo);
    }


    public void handleStudentMessage(Student student) {
        System.out.println(student);
    }
}
