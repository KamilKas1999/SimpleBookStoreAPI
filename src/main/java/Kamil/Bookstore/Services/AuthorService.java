package Kamil.Bookstore.Services;

import Kamil.Bookstore.Model.Author;
import Kamil.Bookstore.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService {


    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public Author findAuthor(Long id){
        return authorRepository.findAuthorById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Author addAuthor(Author author){
        return  authorRepository.save(author);
    }

    public void deleteAuthor(Long id){
        authorRepository.deleteById(id);
    }

}
