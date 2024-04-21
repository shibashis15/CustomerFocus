package com.CustomerRelationManager.com.Repository;

import com.CustomerRelationManager.com.Model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order , Long> {

    @Override
    Page<Order> findAll(Pageable pageable);
    List<Order> findByCustomer_CustomerID(Long customerID);
    //List<Order> findOrderByCustID_OrderId(Long )
}
