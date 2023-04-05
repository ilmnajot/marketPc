package uz.marketpc.marketpc.controller;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.marketpc.marketpc.entity.Orders;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.OrdersDTO;
import uz.marketpc.marketpc.service.OrderService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;
    @GetMapping("/all")
    @PreAuthorize(value = "hasAuthority('READ_ALL')")
    public List<OrdersDTO> getAllOrders(){
        return orderService.getAllOrders();
    }
    @PostMapping
    @PreAuthorize(value = "hasAuthority('CREATE')")
    public HttpEntity<?> saveOrder(@RequestBody OrdersDTO ordersDTO){
        return ResponseEntity.ok(orderService.AddOrder(ordersDTO));
    }
    @GetMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('READ_ONE')")
    public HttpEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(orderService.getOrder(id));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('DELETE')")
    public HttpEntity<?> deleteOrderById(@PathVariable Long id){
        ApiResponse apiResponse = orderService.deleteOrder(id);
        if (apiResponse.isSuccess()){
            return ResponseEntity.status(HttpStatus.NOT_EXTENDED).body(apiResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);

    }
    @PutMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('UPDATE')")
    public HttpEntity<?> updateOrder(@PathVariable Long id, OrdersDTO ordersDTO){
        return ResponseEntity.ok(orderService.editOrder(id, ordersDTO));
    }

}
