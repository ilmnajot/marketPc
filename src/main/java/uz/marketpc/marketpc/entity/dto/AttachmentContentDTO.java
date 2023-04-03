package uz.marketpc.marketpc.entity.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentContentDTO {
    private Long id;
    @NotNull(message = "size cannot be blank")
    private Byte size;
}
