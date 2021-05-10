package Kamil.Bookstore.Controller;

import Kamil.Bookstore.Services.AddresService;
import Kamil.Bookstore.Model.Addres;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddresController {
    private final AddresService addresService;

    public AddresController(AddresService addresService) {
        this.addresService = addresService;
    }

    @GetMapping()
    public ResponseEntity<List<Addres>> getAddresses(){
        List<Addres> addreses = addresService.getAll();
        return  new ResponseEntity<>(addreses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Addres> getAddres(@PathVariable("id") Long id){
        Addres addres = addresService.findById(id);
        return  new ResponseEntity<>(addres, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Addres> addBook(@RequestBody Addres addres){
        Addres newAddres = addresService.addAddres(addres);
        return  new ResponseEntity<>(newAddres,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Addres> updateAddres(@PathVariable("id") Long id, @RequestBody Addres addres){
        Addres updatedAddres = addresService.updateAddres(id, addres);
        return  new ResponseEntity<>(updatedAddres,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddres(@PathVariable("id") Long id){
        addresService.deleteAddres(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
