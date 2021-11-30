package it.univr.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/book")
    public Book createBook(@RequestParam("title") String title, @RequestParam("author") String author,
                           @RequestParam ("price") Float price) {
        Book book = new Book(title, author, price);
        bookRepository.save(book);
        return book;
    }

    @GetMapping("/book/{bookId}")
    public Optional<Book> readBook(@PathVariable("bookId") Long id) {
        return bookRepository.findById(id);
    }

    // Search by title:
    @GetMapping("/bookByTitle/{bookTitle}")
    public Iterable<Book> readBookName(@PathVariable("bookTitle") String title) {

        return bookRepository.findByTitleContains(title);
    }

    // Search by author:
    @GetMapping("/bookByAuthor/{bookAuthor}")
    public Iterable<Book> readBookAuthor(@PathVariable("bookAuthor") String author) {
        return bookRepository.findByAuthorContains(author);
    }

    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book) {
        bookRepository.save(book);
        return book;
    }

    @DeleteMapping("/book")
    public void deleteBook(@RequestParam("id") Long id) {
        bookRepository.deleteById(id);
    }
}
