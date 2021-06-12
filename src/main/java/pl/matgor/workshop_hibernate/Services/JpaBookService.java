package pl.matgor.workshop_hibernate.Services;

import org.springframework.stereotype.Service;
import pl.matgor.workshop_hibernate.Model.Book;
import pl.matgor.workshop_hibernate.Repo.BookRepo;

import java.util.List;
import java.util.Optional;
@Service
public class JpaBookService implements BookService {
    private final BookRepo bookRepo;
    public JpaBookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public void addBook(Book book) {
        bookRepo.save(book);
    }

    @Override
    public Optional<Book> get(Long id) {
        return bookRepo.findById(id);
    }

    @Override
    public List<Book> getListOfBooks() {
        return bookRepo.findAll();
    }

    @Override
    public void editBook(Book book) {
        bookRepo.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }




}
