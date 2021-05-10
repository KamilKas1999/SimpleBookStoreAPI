package Kamil.Bookstore.Services;

import Kamil.Bookstore.Model.Type;
import Kamil.Bookstore.Repository.TypesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypesService {


    private final TypesRepository typesRepository;

    public TypesService(TypesRepository typesRepository) {
        this.typesRepository = typesRepository;
    }

    public List<Type> findAll(){
        return typesRepository.findAll();
    }

    public Type findAuthor(Long id){
        return typesRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Type addType(Type type){
        return typesRepository.save(type);
    }


    public void deleteType(Long id){
        typesRepository.deleteById(id);
    }
}
