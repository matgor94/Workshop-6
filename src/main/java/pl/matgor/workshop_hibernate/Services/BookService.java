package pl.matgor.workshop_hibernate.Services;

import pl.matgor.workshop_hibernate.Model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    void addBook(Book book);
    Optional<Book> get(Long id);
    List<Book> getListOfBooks();
    void editBook(Book book);
    void deleteBook(Long id);
}
