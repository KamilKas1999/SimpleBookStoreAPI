package Kamil.Bookstore.Controller;

import Kamil.Bookstore.Services.BookService;
import Kamil.Bookstore.Repository.AuthorRepository;
import Kamil.Bookstore.Model.Book.Book;
import Kamil.Bookstore.Model.Book.BookWrite;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookControler {
    private final BookService bookService;
    private final AuthorRepository authorRepository;

    public BookControler(BookService bookService, AuthorRepository authorRepository) {
        this.bookService = bookService;
        this.authorRepository = authorRepository;
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookService.getBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBook(@PathVariable("id") Long id) {
        Book foundedBook = bookService.findBook(id);
        return new ResponseEntity<>(foundedBook, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBook(@RequestParam String name) {
        System.out.println(name);
        List<Book> books = bookService.searchBook(name);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }


        @PostMapping("")
        public ResponseEntity<Book> addBook(@RequestBody BookWrite bookwrite) {
            Book newBook = bookService.addBook(bookwrite);
            return new ResponseEntity<>(newBook, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
            bookService.deleteBook(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }



    }

