package Kamil.Bookstore.Repository;

import Kamil.Bookstore.Model.File.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, String> {

}
