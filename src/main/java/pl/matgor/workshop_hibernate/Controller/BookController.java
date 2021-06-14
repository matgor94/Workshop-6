package pl.matgor.workshop_hibernate.Controller;

import lombok.experimental.PackagePrivate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.matgor.workshop_hibernate.Model.Book;
import pl.matgor.workshop_hibernate.Services.BookService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/allBooks")
    public String showBookList(Model model){
        model.addAttribute("bookList", bookService.getListOfBooks());
        return "allBooks";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "addBookForm";
    }
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String saveBook(@Valid Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addBookForm";
        }
        bookService.addBook(book);
        return "redirect:/book/allBooks";
    }

    @RequestMapping(value = "/editBook/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable long id, Model model){
        model.addAttribute("book", bookService.get(id));
        return "editBookForm.jsp";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
        return "redirect:/book/allBooks";
    }

    @GetMapping("/details/{id}")
    public String detailsOfBook(@PathVariable long id, Model model){
        model.addAttribute("book", bookService.get(id).orElseThrow(EntityNotFoundException::new));
        return "detailsBook";
    }

}
