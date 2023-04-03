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
@Table
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToOne(cascade =CascadeType.ALL)
    private Products products;
    @OneToMany(cascade = CascadeType.ALL)
    private List<AttachmentContent> attachmentContents;

    @OneToOne(mappedBy = "attachment", cascade = CascadeType.ALL)
    private Blogs blogs;


}
