package pl.matgor.workshop_hibernate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.matgor.workshop_hibernate.Model.Book;
import pl.matgor.workshop_hibernate.Services.BookService;

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


}
