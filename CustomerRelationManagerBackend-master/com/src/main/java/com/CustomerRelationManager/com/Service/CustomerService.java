package com.CustomerRelationManager.com.Service;


import com.CustomerRelationManager.com.Model.Customer;
import com.CustomerRelationManager.com.Model.Order;
import com.CustomerRelationManager.com.Repository.CustomerRepository;
import com.CustomerRelationManager.com.Repository.OrderRepository;

import com.CustomerRelationManager.com.util.CustomerExistsException;
import com.CustomerRelationManager.com.util.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public Page<Customer> findAll(Pageable pageable){
        return customerRepository.findAll(pageable);
    }
    public Customer findByID(Long customerId)  throws CustomerNotFoundException {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(!customerOptional.isPresent())
            throw new CustomerNotFoundException("Customer Not Found");
        return customerOptional.get();
    }

    public Customer addCustomer(Customer customer) throws CustomerExistsException {
        if(customerRepository.findById(customer.getCustomerID()).isPresent() || customerRepository.findBycustomerEmail(customer.getCustomerEmail()).isPresent() || customerRepository.findByphoneNo(customer.getPhoneNo()).isPresent())
            throw new CustomerExistsException("Customer Already Exist");
        return customer;
    }
}
