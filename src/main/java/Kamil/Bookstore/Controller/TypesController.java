package Kamil.Bookstore.Controller;

import Kamil.Bookstore.Model.Type;
import Kamil.Bookstore.Services.TypesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypesController {

    private final TypesService typesService;

    public TypesController(TypesService typesService) {
        this.typesService = typesService;
    }

    @GetMapping()
    public ResponseEntity<List<Type>> findAll(){
        List<Type> types= typesService.findAll();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Type> findGenre(@PathVariable("id") Long id){
        Type foundedTypes = typesService.findAuthor(id);
        return  new ResponseEntity<>(foundedTypes, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Type> addGenre(@RequestBody Type type){
        Type newtype = typesService.addType(type);
        return  new ResponseEntity<>(newtype, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteType(@PathVariable("id") Long id){
        typesService.deleteType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
