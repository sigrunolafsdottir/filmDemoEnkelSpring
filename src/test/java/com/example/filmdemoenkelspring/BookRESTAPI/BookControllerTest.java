package com.example.filmdemoenkelspring.BookRESTAPI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllBooks() {
    }

    @Test
    void getBookById() {
    }

    @Test
    void getBookByIdRange() {
    }

    @Test
    void deleteBookById() {
    }

    @Test
    void addByGET() {
    }

    @Test
    void addBookByPOST() {
    }

    @Test
    void updateBook() {
    }
}