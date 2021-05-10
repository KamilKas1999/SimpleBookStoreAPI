package Kamil.Bookstore.Repository;
import Kamil.Bookstore.Model.Book.Book;
import org.springframework.data.repository.CrudRepository;;
import java.util.List;
import java.util.Optional;


public interface BookRepository extends CrudRepository<Book,Long> {


    Optional<Book> findBookById (Long id);
    List<Book> findAll();


}

