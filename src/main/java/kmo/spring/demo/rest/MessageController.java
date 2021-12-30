package kmo.spring.demo.rest;

import kmo.spring.demo.messaging.JmsProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("message")
public class MessageController {

    private final JmsProducer jmsProducer;

    @GetMapping("{message}")
    public ResponseEntity<Void> send(@PathVariable final String message) {
        jmsProducer.send(message);

        return ResponseEntity.accepted().build();
    }
}
