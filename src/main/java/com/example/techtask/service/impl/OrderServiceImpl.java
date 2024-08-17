package com.example.techtask.service.impl;

import com.example.techtask.model.Order;
import com.example.techtask.repository.OrderRepository;
import com.example.techtask.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order findOrder() {
        //3. Возвращать самый новый заказ, в котором больше одного предмета.
        Order order = orderRepository.findNewestOrderWithQuantityMoreThanOne();
        return order;
    }

    @Override
    public List<Order> findOrders() {
        //4. Возвращать заказы от активных пользователей, отсортированные по дате создания.
        List<Order> orders = orderRepository.findOrdersFromActiveUsersSortedByDate();
        return orders;
    }
}
