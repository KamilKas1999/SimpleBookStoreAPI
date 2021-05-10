package Kamil.Bookstore.Services;

import Kamil.Bookstore.Model.Genre;
import Kamil.Bookstore.Repository.GenresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenresService {


    private final GenresRepository genresRepository;

    public GenresService(GenresRepository genresRepository) {
        this.genresRepository = genresRepository;
    }

    public List<Genre> findAll(){
        return genresRepository.findAll();
    }

    public Genre findAuthor(Long id){
        return genresRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Genre addGenre(Genre genre){
        return genresRepository.save(genre);
    }

    public void deleteGenre(Long id){
        genresRepository.deleteById(id);
    }

}
