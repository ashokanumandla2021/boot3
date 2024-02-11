package io.ashok.boot3;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageClient {
    private final JmsTemplate jmsTemplate;

    boolean publishMessage(String destination, String body) {
        try {
            jmsTemplate.convertAndSend(destination, body);
            System.out.println("Published the message to " + destination);
            return true;
        } catch (JmsException e) {
            throw new RuntimeException(e);
        }
    }
}
