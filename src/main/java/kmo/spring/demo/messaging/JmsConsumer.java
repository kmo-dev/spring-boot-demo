package kmo.spring.demo.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JmsConsumer {

    @JmsListener(destination = "my-queue-1")
    public void receiveQueueMessage(String message) {
        log.info("Received queue message='{}'", message);
    }


}