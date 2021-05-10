package Kamil.Bookstore.Services;

import Kamil.Bookstore.Repository.OrderRepository;
import Kamil.Bookstore.Repository.StatusRepository;
import Kamil.Bookstore.Model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
private final StatusRepository statusRepository;
    public OrderService(OrderRepository orderRepository, StatusRepository statusRepository) {
        this.orderRepository = orderRepository;
        this.statusRepository = statusRepository;
    }


    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        return orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Order addAddres(Order order){
        order.setStatus(statusRepository.findById(1L).get());
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder){
        updatedOrder.setId(id);
        return orderRepository.save(updatedOrder);
    }

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }

}
