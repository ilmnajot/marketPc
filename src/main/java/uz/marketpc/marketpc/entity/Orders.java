package uz.marketpc.marketpc.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "address")

    private String address;
    @Column(name="full_name")

    private String fullName;
    @Column(name="phone_number")

    private String phoneNumber;
    @Column(name = "email")

    private String email;
    @Column(name = "info")

    private String info;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Products> products;

}
