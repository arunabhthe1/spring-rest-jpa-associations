package com.dash.demoproject.kafkaconfig.consumer;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LibraryEventConsumer {
    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.topic.groupid}")
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord ){
        log.info("Consumed message via consumer {}", consumerRecord);

    }
}
