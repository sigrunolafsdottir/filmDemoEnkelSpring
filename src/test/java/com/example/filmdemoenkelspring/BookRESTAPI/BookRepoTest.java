package com.example.filmdemoenkelspring.BookRESTAPI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepoTest {


    private BookRepo bookRepo = new BookRepo();

    @Test
    void getBookList() {
        List<Book> bookList = bookRepo.getBookList();
        assert(bookList.size() == 7);
        assert(bookList.get(0).getTitle().equalsIgnoreCase("Jayne Eyre"));
    }
}