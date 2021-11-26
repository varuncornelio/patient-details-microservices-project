//USE PATIENT CONTROLLER AS REFERENCE AND UPDATE THIS FILE.
// NOTHING MAJOR TO BE DONE OTHER THAN NAME CHANGING
//DO NOT FORGET TO UPDATE THE PACKAGE AND IMPORT PATHS BELOW PROPERLY, EVEN THOUGH WE ARE DOING FOR DOCTORS, THE PATH WILL BE THROUGH "orderservice", SO MIND THAT.
//ONCE DONE ALL CHANGES, RENAME FILE TO "DoctorController.java"


package com.example.orderservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.List;
@RequestMapping("/doctors")
@RestController
public class OrderController {
    private final List<Order> orders = Arrays.asList(
            new Order(1, 1, "A"),
            new Order(2, 1, "Product B"),
            new Order(3, 2, "Product C"),
            new Order(4, 1, "Product D"),
            new Order(5, 2, "Product E"));

    @GetMapping("/getAllDoctors")
    public List<Order> getAllOrders() {
        return orders;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orders.stream()
                     .filter(order -> order.getId() == id)
                     .findFirst()
                     .orElseThrow(IllegalArgumentException::new);
    }
}