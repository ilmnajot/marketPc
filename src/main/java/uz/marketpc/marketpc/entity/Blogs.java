package uz.marketpc.marketpc.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "blogs")
public class Blogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")

    private String name;
    @Column(name = "info")

    private String info;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "attachment_id", referencedColumnName = "id")
    private Attachment attachment;
}
