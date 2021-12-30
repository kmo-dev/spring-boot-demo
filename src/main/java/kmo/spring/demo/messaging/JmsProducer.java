package kmo.spring.demo.messaging;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class JmsProducer {

    private final JmsTemplate jmsTemplate;

    public void send(final String message) {
        final var queue = "my-queue-1";

        jmsTemplate.convertAndSend(queue, message);

        log.info("Sent message='{}'", message);
    }
}