package com.sukru.awsdemo.controller;

import com.sukru.awsdemo.dao.Order;
import com.sukru.awsdemo.repo.OrderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderDao orderDao;

    @GetMapping("/orders")

    public List<Order> fetchOrders() {
        return orderDao.getOrders().stream().
                sorted(Comparator.comparing(Order::getPrice))
                .collect(Collectors.toList());
    }
}
