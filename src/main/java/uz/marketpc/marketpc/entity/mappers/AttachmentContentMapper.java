package uz.marketpc.marketpc.entity.mappers;

import org.mapstruct.Mapper;
import uz.marketpc.marketpc.entity.Attachment;
import uz.marketpc.marketpc.entity.AttachmentContent;
import uz.marketpc.marketpc.entity.dto.AttachmentContentDTO;

@Mapper(componentModel = "spring")
public interface AttachmentContentMapper {

    AttachmentContentDTO attachmentContentToAttachmentContentDTO(AttachmentContent attachmentContent);
    AttachmentContent attachmentContentDTOTOAttachmentContent(AttachmentContentDTO attachmentContentDTO);
}
