package com.CustomerRelationManager.com.Service;

import com.CustomerRelationManager.com.Model.Customer;
import com.CustomerRelationManager.com.Model.Order;
import com.CustomerRelationManager.com.Repository.OrderRepository;
import com.CustomerRelationManager.com.util.CustomerNotFoundException;
import com.CustomerRelationManager.com.util.OrderNotFoundException;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerService customerService;
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public Optional<Order> findById(Long orderId) throws OrderNotFoundException{
        Optional<Order>orderOptional = orderRepository.findById(orderId);
        if(!orderOptional.isPresent())
            throw new OrderNotFoundException("Order Not Found!");
        return orderOptional;
    }
    public List<Order> findOrderByCustomer(Long customerId)throws CustomerNotFoundException {
        customerService.findByID(customerId);
        return orderRepository.findByCustomer_CustomerID(customerId);
    }
}
