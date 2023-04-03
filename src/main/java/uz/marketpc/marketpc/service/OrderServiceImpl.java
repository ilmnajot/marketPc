package uz.marketpc.marketpc.service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.marketpc.marketpc.entity.Orders;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.OrdersDTO;
import uz.marketpc.marketpc.entity.mappers.OrderMapper;
import uz.marketpc.marketpc.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor

public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private OrderMapper mapper;
    @Override
    public List<OrdersDTO> getAllOrders() {
        return orderRepository.findAll(Sort.by("id"))
                .stream()
                .map(mapper::OrdersToOrdersDTO)
                .collect(Collectors.toList());
    }
    @Override
    public ApiResponse AddOrder(OrdersDTO ordersDTO) {
        Orders orders = mapper.OrdersDTOToOrders(ordersDTO);
        orderRepository.save(orders);
        return new ApiResponse("your order received successfully, thank you for your order", true);
    }

    @Override
    public Orders getOrder(Long id) {
        Optional<Orders> byId = orderRepository.findById(id);
        if (byId.isPresent())
            return orderRepository.findById(id).get();
        return null;
    }
    @Override
    public ApiResponse deleteOrder(Long id) {
        boolean existsById = orderRepository.existsById(id);
        if (existsById){
            orderRepository.deleteById(id);
        return new ApiResponse("your order deleted successfully", true);
    }
        return new ApiResponse("category is not existent", false);
    }
    @Override
    public ApiResponse editOrder(Long id, OrdersDTO ordersDTO) {
        boolean existsById = orderRepository.existsById(id);
        if (existsById) {
        ordersDTO.setId(id);
            Orders orders = mapper.OrdersDTOToOrders(ordersDTO);
            orderRepository.save(orders);
            return new ApiResponse("updated successfully", true);
        }
        return new ApiResponse("no such order", false);
        }
}

