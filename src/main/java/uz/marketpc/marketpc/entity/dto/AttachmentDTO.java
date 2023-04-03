package uz.marketpc.marketpc.entity.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AttachmentDTO {
    private Long id;

    @NotNull(message="name cannot be blank")
    private String name;
}
