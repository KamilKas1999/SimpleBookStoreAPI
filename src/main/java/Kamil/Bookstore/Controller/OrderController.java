package Kamil.Bookstore.Controller;

import Kamil.Bookstore.Model.Order;
import Kamil.Bookstore.Services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getAddresses(){
        List<Order> orders = orderService.getAll();
        return  new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getAddres(@PathVariable("id") Long id){
        Order order = orderService.findById(id);
        return  new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Order> addBook(@RequestBody Order order){
        Order newOrder = orderService.addAddres(order);
        return  new ResponseEntity<>(newOrder,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateAddres(@PathVariable("id") Long id, @RequestBody Order order){
        Order updatedOrder = orderService.updateOrder(id, order);
        return  new ResponseEntity<>(updatedOrder,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Long id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
