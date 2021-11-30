package it.univr.bookstore;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    Iterable<Book> findByTitleContains(String title);
    Iterable<Book> findByAuthorContains(String author);
}
