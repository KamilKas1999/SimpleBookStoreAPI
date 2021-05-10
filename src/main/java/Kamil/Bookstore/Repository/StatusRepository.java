package Kamil.Bookstore.Repository;

import Kamil.Bookstore.Model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,Long> {
}
