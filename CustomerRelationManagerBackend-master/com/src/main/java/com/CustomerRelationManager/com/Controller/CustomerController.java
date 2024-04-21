package com.CustomerRelationManager.com.Controller;

import com.CustomerRelationManager.com.Model.Customer;
import com.CustomerRelationManager.com.Service.CustomerService;
import com.CustomerRelationManager.com.util.CustomerExistsException;
import com.CustomerRelationManager.com.util.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("home/customer")
public class CustomerController {
    @Autowired
    CustomerService CustomerService;
    @GetMapping("/customerList")
    public ResponseEntity<Page<Customer>> getAllCustomers(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "customerID") String []sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        Page<Customer> list = CustomerService.findAll(pageable);

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/customerList/findByID/{customerId}")
    public ResponseEntity<Customer> getById(@PathVariable Long customerId) throws CustomerNotFoundException  {
        return new ResponseEntity<Customer>(CustomerService.findByID(customerId) , HttpStatus.OK);
    }
    @PostMapping("/customersList/addNewCustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws CustomerExistsException {
        return new ResponseEntity<>(CustomerService.addCustomer(customer) , HttpStatus.OK);
    }
}
