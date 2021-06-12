package pl.matgor.workshop_hibernate.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.matgor.workshop_hibernate.Model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
}
