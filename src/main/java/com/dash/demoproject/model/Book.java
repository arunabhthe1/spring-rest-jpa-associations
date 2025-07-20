package com.dash.demoproject.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private Integer bookId;
    private String bookName;
    private String autherName;
}
