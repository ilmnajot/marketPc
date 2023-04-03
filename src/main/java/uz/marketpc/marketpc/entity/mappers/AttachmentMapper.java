package uz.marketpc.marketpc.entity.mappers;

import org.mapstruct.Mapper;
import uz.marketpc.marketpc.entity.Attachment;
import uz.marketpc.marketpc.entity.dto.AttachmentDTO;

@Mapper(componentModel = "spring")
public interface AttachmentMapper {
    AttachmentDTO attachmentToAttachmentDTO(Attachment attachment);
    Attachment attachmentDTOToAttachment(AttachmentDTO attachmentDTO);
}
