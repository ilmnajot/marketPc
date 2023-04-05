package uz.marketpc.marketpc.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")

public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")

    private String name;
    @Column(name = "description")

    private String description;
    @Column(name = "product_price")

    private double productPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="attachment_id", referencedColumnName = "id")
    private Attachment attachment;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Orders> orders;


}
