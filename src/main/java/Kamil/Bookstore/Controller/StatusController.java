package Kamil.Bookstore.Controller;

import Kamil.Bookstore.Model.Status;
import Kamil.Bookstore.Services.StatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {
    private final StatusService statusRepository;


    public StatusController(StatusService statusRepository) {
        this.statusRepository = statusRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Status>> getAddresses(){
        List<Status> statuses = statusRepository.getAll();
        return  new ResponseEntity<>(statuses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> getAddres(@PathVariable("id") Long id){
        Status status = statusRepository.findById(id);
        return  new ResponseEntity<>(status, HttpStatus.OK);
    }
}
