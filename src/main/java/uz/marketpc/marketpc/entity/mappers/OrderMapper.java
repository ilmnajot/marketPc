package uz.marketpc.marketpc.entity.mappers;

import org.mapstruct.Mapper;
import uz.marketpc.marketpc.entity.Orders;
import uz.marketpc.marketpc.entity.dto.OrdersDTO;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrdersDTO OrdersToOrdersDTO(Orders orders);
    Orders OrdersDTOToOrders(OrdersDTO ordersDTO);
}
