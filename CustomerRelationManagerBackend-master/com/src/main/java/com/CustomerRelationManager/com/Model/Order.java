package com.CustomerRelationManager.com.Model;


import javax.persistence.*;

@Entity
@Table(name = "OrderTable")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderID")
    private Long orderId;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @Column(name = "date")
    private String orderDate;
    @Column(name = "Price")
    private String orderPrice;
    @Column(name = "modeOfPayment")
    private String modeOfPayment;
    @Column(name = "ItemType")
    private String itemType;
    @Column(name = "ItemId" , unique = true)
    private Long itemId;

    public Order(Long orderId, Customer customer, String orderDate, String orderPrice, String modeOfPayment, String itemType, Long itemId) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDate = orderDate;
        this.orderPrice = orderPrice;
        this.modeOfPayment = modeOfPayment;
        this.itemType = itemType;
        this.itemId = itemId;
    }

    public Order(){}

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }


    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    public Long getItemId() {
        return itemId;
    }
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
