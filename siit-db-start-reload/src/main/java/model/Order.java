package model;

import java.time.LocalDate;

public class Order {
    private String number;
    private LocalDate placed;
    private Integer customer_id;
    private Integer id;
    public  Order(){

    }

    public Order(String number, LocalDate placed, Integer customer_id, Integer id) {
        this.number = number;
        this.placed = placed;
        this.customer_id = customer_id;
        this.id = id;
    }



    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getPlaced() {
        return placed;
    }

    public void setPlaced(LocalDate placed) {
        this.placed = placed;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "number='" + number + '\'' +
                ", placed=" + placed +
                ", customer_id=" + customer_id +
                ", id=" + id +
                '}';
    }
}

