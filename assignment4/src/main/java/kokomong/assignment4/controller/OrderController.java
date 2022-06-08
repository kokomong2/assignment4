package kokomong.assignment4.controller;


import kokomong.assignment4.domain.Orders;
import kokomong.assignment4.dto.orders.OrderRequestDto;
import kokomong.assignment4.repository.OrderRepository;
import kokomong.assignment4.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderService orderService;


    @PostMapping("/order/request")
    public Orders addOrders(@RequestBody OrderRequestDto orderRequestDto){
        return orderService.toResponseOrder(orderRequestDto);
    }

    @GetMapping("/orders")
    public List<Orders> getOrders(){
        return orderRepository.findAll();
    }
}
