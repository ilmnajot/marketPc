package uz.marketpc.marketpc.service;

import uz.marketpc.marketpc.entity.Orders;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.OrdersDTO;

import java.util.List;

public interface OrderService {
    List<OrdersDTO> getAllOrders();
    ApiResponse AddOrder(OrdersDTO ordersDTO);
    Orders getOrder(Long id);
    ApiResponse deleteOrder(Long id);
    ApiResponse editOrder(Long id, OrdersDTO ordersDTO);
}
