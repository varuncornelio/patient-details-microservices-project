//YOU HAVE TO UPDATE THIS CODE
//RETAIN CUSTOMER ID, RENAME IT TO PATIENT ID, AND DO SIMILAR CHANGES WHEREVER IT OCCURS
//ONCE DONE ALL CHANGES, RENAME FILE AS "Doctor.java"

package com.example.orderservice;
public class Order {
    private final int id;
    private final int customerId;
    private final String name;

    public Order(final int id, final int customerId, final String name) {
        this.id = id;
        this.customerId = customerId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}