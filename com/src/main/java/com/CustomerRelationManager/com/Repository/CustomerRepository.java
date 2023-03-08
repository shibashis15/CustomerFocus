package com.CustomerRelationManager.com.Repository;

import com.CustomerRelationManager.com.Model.Customer;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface  CustomerRepository extends JpaRepository<Customer, Long>{
    @Override
    Page<Customer> findAll(Pageable pageable);
    public Optional<Customer>findBycustomerEmail(String customerEmail);
    public Optional<Customer>findByphoneNo(String phoneNo);

}
