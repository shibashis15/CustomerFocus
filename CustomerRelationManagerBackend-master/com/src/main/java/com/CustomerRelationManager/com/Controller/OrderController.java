package com.CustomerRelationManager.com.Controller;

import com.CustomerRelationManager.com.Model.Order;
import com.CustomerRelationManager.com.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("home/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/orderList")
    public ResponseEntity<Page<Order>> getAllOrder(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "orderDate") String []sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(sortBy).ascending());
        Page<Order> orderPage = orderService.findAll(pageable);
        return new ResponseEntity<>(orderPage, HttpStatus.OK);
    }
    @GetMapping("/orderList/findByID/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable Long orderId) {
        return new ResponseEntity<>(orderService.findById(orderId).get() , HttpStatus.OK);
    }
    @GetMapping("/orderList/findByCustID/{customerId}/")
    public ResponseEntity<List<Order>> getALLOrderByCustID(@PathVariable Long customerId) {
        return new ResponseEntity<>(orderService.findOrderByCustomer(customerId) , HttpStatus.OK);
    }
    @GetMapping("/orderList/findByCustID/{customerId}/{orderId}")
    public ResponseEntity<List<Order>> getALLOrderByCustID_OrderId(@PathVariable Long customerId , @PathVariable Long orderId)  {
        return new ResponseEntity<>(orderService.findOrderByCustomer(customerId) , HttpStatus.OK);
    }

}
