package Kamil.Bookstore.Services;

import Kamil.Bookstore.Model.Status;
import Kamil.Bookstore.Repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> getAll(){
        return statusRepository.findAll();
    }

    public Status findById(Long id){
        return statusRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }
}
