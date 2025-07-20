package com.dash.demoproject.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LibraryEvent {
    private Integer libraryEventId;
    private Book book;

}
