package com.example.filmdemoenkelspring.BookRESTAPI;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.ui.Model;

@RestController
public class BookController {

    BookRepo br = new BookRepo();
    List<Book> bookList = br.getBookList();

    @RequestMapping("/books")
    public List<Book> getAllBooks(){
        return bookList;
    }

    @RequestMapping("/books/{id}")
    public Book getBookById(@PathVariable int id){
        return bookList.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    @RequestMapping("/books/{fromid}/{toid}")
    public List<Book> getBookByIdRange(@PathVariable int toid, @PathVariable int fromid){
        return bookList.stream().filter(b -> b.getId() >= fromid && b.getId() <= toid).toList();
    }

    @RequestMapping("/books/{id}/delete")
    public List<Book> deleteBookById(@PathVariable int id){
        bookList.removeIf(b -> b.getId() == id);
        return bookList;
    }

    @RequestMapping("/books/addByGET")
    public List<Book> addByGET(@RequestParam int id,
                               @RequestParam String title, @RequestParam String author){
        bookList.add(new Book(id, title, author));
        return bookList;
    }

    @PostMapping("/books/add")
    public List<Book> addBookByPOST(@RequestBody Book b){
        bookList.add(b);
        return bookList;
    }

    @PutMapping("/books/update")
    public List<Book> updateBook(@RequestBody Book b){
        Book bookToUpdate = bookList.stream()
                .filter(book -> book.getId()==b.getId()).findFirst().orElse(null);
        if (bookToUpdate == null) {
            bookList.add(b);
        }
        else{
            bookToUpdate.setTitle(b.getTitle());
            bookToUpdate.setAuthor(b.getAuthor());
        }
        return bookList;
    }

}
