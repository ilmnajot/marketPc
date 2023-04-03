package uz.marketpc.marketpc.service;

import uz.marketpc.marketpc.entity.AttachmentContent;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.AttachmentContentDTO;

import java.util.List;

public interface AttachmentContentService {

    List<AttachmentContentDTO> getAllAttachmentContent();
    ApiResponse addAttachmentContent(AttachmentContentDTO attachmentContentDTO);
    AttachmentContent getById(Long id);
    ApiResponse deleteAttachmentContent(Long id);
    ApiResponse updateContent(Long id, AttachmentContentDTO attachmentContentDTO);
}
