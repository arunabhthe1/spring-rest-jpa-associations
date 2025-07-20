package com.dash.demoproject.kafkaconfig.producer;

import com.dash.demoproject.model.LibraryEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LibraryEventProducer {
    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    //private final Logger LOGGER= LoggerFactory.getLogger(this.getClass());

    @Value("${spring.kafka.producer.topic}")
    private String topicName;

    @Autowired
    private ObjectMapper objectMapper;
    public void sendMessage(LibraryEvent libraryEvent) throws JsonProcessingException {
        log.info(" Sending the message to the service for adding library {} in the topic {}",libraryEvent,topicName);

        var key=libraryEvent.getLibraryEventId();
        var value=objectMapper.writeValueAsString(libraryEvent);
        ProducerRecord<Integer, String> producerRecord=new ProducerRecord<>(topicName,key,value);
        log.info(" The producer record is {}",producerRecord);
        var listenableFuture=this.kafkaTemplate.send(producerRecord);
        var combletableFuture=listenableFuture.completable();
        combletableFuture.whenComplete((sendResult, throwable) -> {
            if(throwable!= null){
                log.info("Message sent successfully with body {}",value);
            }else{
                log.info("Message sent successfully {}", throwable.getMessage());
            }
        });
    }
}
