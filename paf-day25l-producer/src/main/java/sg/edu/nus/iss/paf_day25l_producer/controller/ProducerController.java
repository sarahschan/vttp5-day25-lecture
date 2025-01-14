package sg.edu.nus.iss.paf_day25l_producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.paf_day25l_producer.model.Todo;
import sg.edu.nus.iss.paf_day25l_producer.service.ProducerService;

@RestController
@RequestMapping("/api/messages")
public class ProducerController {
    
    @Autowired
    ProducerService producerService;

    @PostMapping()
    public ResponseEntity<String> sendMessage(@RequestBody Todo todo) {
        
        producerService.sendMessage(todo);
        
        return new ResponseEntity<>("Message sent", HttpStatus.OK);

    }
}
