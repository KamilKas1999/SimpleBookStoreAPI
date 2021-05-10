package Kamil.Bookstore.Repository;

import Kamil.Bookstore.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
