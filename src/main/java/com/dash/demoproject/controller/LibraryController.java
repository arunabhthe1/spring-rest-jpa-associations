package com.dash.demoproject.controller;

import com.dash.demoproject.kafkaconfig.producer.LibraryEventProducer;
import com.dash.demoproject.model.LibraryEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LibraryController {
    //private final Logger LOGGER= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LibraryEventProducer libraryEventProducer;
    @PostMapping(value="/publishLibrary")
    public ResponseEntity<LibraryEvent> publishLibraryEvent(@RequestBody LibraryEvent libraryEvent)
    {
        log.info(" Sending the message to the controller for adding library {}",libraryEvent);
        try {
            libraryEventProducer.sendMessage(libraryEvent);
            return ResponseEntity.status(HttpStatus.OK).body(libraryEvent);
        } catch (JsonProcessingException e) {
            log.error(" Getting JsonProcessingException exception {}",e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }
}
