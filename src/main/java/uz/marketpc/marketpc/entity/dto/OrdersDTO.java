package uz.marketpc.marketpc.entity.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdersDTO {
    private Long id;
    @NotNull(message="address cannot be blank")
    private String address;
    @NotNull(message="fullName cannot be blank")
    private String fullName;
    @NotNull(message="phoneNumber cannot be blank")
    private String phoneNumber;
    @NotNull(message="email cannot be blank")
    private String email;
    @NotNull(message="info cannot be blank")
    private String info;
}
