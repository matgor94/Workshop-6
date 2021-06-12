package pl.matgor.workshop_hibernate.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="books")
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;
}
