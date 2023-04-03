package uz.marketpc.marketpc.service;

import uz.marketpc.marketpc.entity.Attachment;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.AttachmentDTO;

import java.util.List;
import java.util.Optional;

public interface AttachmentService {
     List<AttachmentDTO> findAttachments();
     ApiResponse addAttachment(AttachmentDTO attachmentDTO);
    Attachment getAttachment(Long id);
     ApiResponse deleteAttachment(Long id);
     ApiResponse editAttachment(Long id, AttachmentDTO attachmentDTO);
}
