package com.CustomerRelationManager.com.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Long customerID;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "address")
    private String address;
    @Column(name = "phoneNo" , unique = true)
    private String phoneNo;
    @Column(name = "customerEmail" , unique = true)
    private String customerEmail;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orderList;
    public Customer() {

    }

    public Customer(Long customerID, String customerName, String phoneNo , String customerEmail , String address , List<Order>orderList) {
        super();
        this.customerID = customerID;
        this.customerName = customerName;
        this.phoneNo = phoneNo;
        this.address=address;
        this.customerEmail = customerEmail;
        this.orderList = orderList;
    }

    public Long getCustomerID() {
        return customerID;
    }
    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    public void setAddress(String address){this.address=address;}
    public String getAddress(){return address;}
    public List<Order> getOrderList() {
        return orderList;
    }
    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
