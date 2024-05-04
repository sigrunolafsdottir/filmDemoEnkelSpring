package com.example.filmdemoenkelspring.BookRESTAPI;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class BookHATEOASController {

    BookRepo br = new BookRepo();
    List<Book> bookList = br.getBookList();


    @GetMapping("/booksHATEOAS/{id}")
    EntityModel<Book> one(@PathVariable Long id) {

        Book book = bookList.stream().filter(b -> b.getId() == id).findFirst().orElse(null);

        return EntityModel.of(book, //
                linkTo(methodOn(BookHATEOASController.class).one(id)).withSelfRel(),
                linkTo(methodOn(BookController.class).getAllBooks()).withRel("books"));
    }



    @GetMapping("/booksHATEOAS")
    CollectionModel<EntityModel<Book>> all() {

        List<EntityModel<Book>> books = bookList.stream()
                .map(book -> EntityModel.of(book,
                        linkTo(methodOn(BookHATEOASController.class).one((long)book.getId())).withSelfRel(),
                        linkTo(methodOn(BookHATEOASController.class).all()).withRel("books"))).toList();

        return CollectionModel.of(books, linkTo(methodOn(BookHATEOASController.class).all()).withSelfRel());
    }


}
