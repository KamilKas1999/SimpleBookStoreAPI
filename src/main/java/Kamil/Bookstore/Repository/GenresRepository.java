package Kamil.Bookstore.Repository;

import Kamil.Bookstore.Model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GenresRepository extends JpaRepository<Genre,Long> {

}
