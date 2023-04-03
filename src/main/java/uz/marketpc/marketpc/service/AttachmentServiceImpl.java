package uz.marketpc.marketpc.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.marketpc.marketpc.entity.Attachment;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.AttachmentDTO;
import uz.marketpc.marketpc.entity.mappers.AttachmentMapper;
import uz.marketpc.marketpc.repository.AttachmentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AttachmentServiceImpl implements  AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final AttachmentMapper mapper;
    @Override
    public List<AttachmentDTO> findAttachments() {
      return attachmentRepository.findAll(Sort.by("id"))
                .stream()
                .map(mapper::attachmentToAttachmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ApiResponse addAttachment(AttachmentDTO attachmentDTO) {
            Attachment attachment = mapper.attachmentDTOToAttachment(attachmentDTO);
            attachmentRepository.save(attachment);
        return new ApiResponse("saved", true);
    }

    @Override
    public Attachment getAttachment(Long id) {
        boolean existsById = attachmentRepository.existsById(id);
        if (existsById){
            return attachmentRepository.findById(id).get();
        }return null;
    }

    @Override
    public ApiResponse deleteAttachment(Long id) {
        boolean existsById = attachmentRepository.existsById(id);
        if (existsById){
            attachmentRepository.deleteById(id);
            return new ApiResponse("removed successfully", true);
        }
        return new ApiResponse("no such attachment here", false);
    }

    @Override
    public ApiResponse editAttachment(Long id, AttachmentDTO attachmentDTO) {
        boolean existsById = attachmentRepository.existsById(id);
        if (existsById){
            attachmentDTO.setId(id);
            Attachment attachment = mapper.attachmentDTOToAttachment(attachmentDTO);
            attachmentRepository.save(attachment);
            return new ApiResponse("updated", true);
        }
        return new ApiResponse("no such attachment",false);
    }
}
