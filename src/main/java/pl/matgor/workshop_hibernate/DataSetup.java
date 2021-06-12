package pl.matgor.workshop_hibernate;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;
import pl.matgor.workshop_hibernate.Model.Book;
import pl.matgor.workshop_hibernate.Repo.BookRepo;

import java.util.concurrent.atomic.AtomicBoolean;

public class DataSetup {
    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    private final BookRepo bookRepo;

    public DataSetup(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @EventListener
    @Transactional
    public void loadData(ContextRefreshedEvent contextRefreshedEvent){
        if(!atomicBoolean.getAndSet(true)){
            Book book = new Book(null,"111111111", "Grube Wióry", "Rafał Pacześ", "MB", "Novel");
            bookRepo.save(book);
            Book book1 = new Book(null, "2222222", "Thinking in Java", "Bruce Eckel", "I dont know", "Programming book");
            bookRepo.save(book1);
        }
    }
}
