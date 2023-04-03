package uz.marketpc.marketpc.entity.dto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductsDTO {
    @NotNull(message="name cannot be blank")
    private String name;
    @NotNull(message="description cannot be blank")
    private String description;
    @NotNull(message="productPrice cannot be blank")
    private double productPrice;
}
