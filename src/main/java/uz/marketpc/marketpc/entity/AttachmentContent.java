package uz.marketpc.marketpc.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "attachment_content")
public class AttachmentContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "size")
    private Byte size;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="attachment_id",referencedColumnName = "id")
    private Attachment attachment;

}
