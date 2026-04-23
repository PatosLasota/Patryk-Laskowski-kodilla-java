package com.kodilla.hibernate.invoice;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "ITEMS")
public class Item {


    private int id;

    private Product product;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @ManyToOne
    @JoinColumn(name = "INVOICE_ID")
    private Invoice invoice;

    public Item() {};

    public Item(Product product, BigDecimal price, Integer quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.value = price.multiply(new BigDecimal(quantity));
    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }
    @ManyToOne
    @NotNull
    @JoinColumn(name = "PRODUCT_ID")
    public Product getProduct() {
        return product;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "INVOICE_ID")
    public Invoice getInvoice() {
        return invoice;
    }
    @NotNull
    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }
    @NotNull
    @Column(name = "QUANTITY")
    public Integer getQuantity() {
        return quantity;
    }
    @NotNull
    @Column(name = "VALUE")
    public BigDecimal getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
