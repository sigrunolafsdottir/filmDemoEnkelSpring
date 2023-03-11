package com.example.filmdemoenkelspring.BookRESTAPI;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    protected int id;
    protected String title;
    protected String author;

}
