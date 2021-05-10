package Kamil.Bookstore.Controller;

import Kamil.Bookstore.Services.AuthorService;
import Kamil.Bookstore.Model.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public ResponseEntity<List<Author>> findAll(){
        List<Author> authors= authorService.findAll();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findBook(@PathVariable("id") Long id){
        Author foundedAuthor = authorService.findAuthor(id);
        return  new ResponseEntity<>(foundedAuthor, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Author> addBook(@RequestBody Author author){
        Author newAuthor = authorService.addAuthor(author);
        return  new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id){
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
