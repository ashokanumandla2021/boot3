package io.ashok.boot3;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {

    private final MessageClient messageClient;

    @JmsListener(destination = "Q_TEST")
    void listenToMessages(String message) {
        System.out.println(message);
        System.out.println("received message");
        messageClient.publishMessage("Q_RESULT", message);
    }
}
