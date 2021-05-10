package Kamil.Bookstore.Controller;

import Kamil.Bookstore.Services.GenresService;
import Kamil.Bookstore.Model.Genre;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenresController {

    private final GenresService genresService;

    public GenresController(GenresService genresService) {
        this.genresService = genresService;
    }

    @GetMapping()
    public ResponseEntity<List<Genre>> findAll(){
        List<Genre> genres= genresService.findAll();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> findGenre(@PathVariable("id") Long id){
        Genre foundedGenre = genresService.findAuthor(id);
        return  new ResponseEntity<>(foundedGenre, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Genre> addGenre(@RequestBody Genre genre){
        Genre newGenre = genresService.addGenre(genre);
        return  new ResponseEntity<>(newGenre, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGenre(@PathVariable("id") Long id){
        genresService.deleteGenre(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
