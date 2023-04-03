package uz.marketpc.marketpc.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.marketpc.marketpc.entity.AttachmentContent;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.AttachmentContentDTO;
import uz.marketpc.marketpc.entity.mappers.AttachmentContentMapper;
import uz.marketpc.marketpc.entity.mappers.AttachmentMapper;
import uz.marketpc.marketpc.repository.AttachmentContentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AttachmentContentServiceImpl implements AttachmentContentService{
    private final AttachmentContentMapper mapper;
    private final AttachmentContentRepository attachmentContentRepository;
    @Override
    public List<AttachmentContentDTO> getAllAttachmentContent() {
        return attachmentContentRepository.findAll(Sort.by("id"))
                .stream()
                .map(mapper::attachmentContentToAttachmentContentDTO)
                .collect(Collectors.toList());
    }
    @Override
    public ApiResponse addAttachmentContent(AttachmentContentDTO attachmentContentDTO) {
        AttachmentContent attachmentContent = mapper.attachmentContentDTOTOAttachmentContent(attachmentContentDTO);
      attachmentContentRepository.save(attachmentContent);
      return new ApiResponse("saved successfully", true);
    }

    @Override
    public AttachmentContent getById(Long id) {
        boolean existsById = attachmentContentRepository.existsById(id);
        if (existsById){
            return attachmentContentRepository.findById(id).get();
        }
        return null;
    }
    @Override
    public ApiResponse deleteAttachmentContent(Long id) {
        boolean existsById = attachmentContentRepository.existsById(id);
        if (existsById){
            attachmentContentRepository.deleteById(id);
            return new ApiResponse("removed attachmentContent", true);
        }
        return new ApiResponse("no such AttachmentContent here", false);
    }

    @Override
    public ApiResponse updateContent(Long id, AttachmentContentDTO attachmentContentDTO) {
        boolean existsById = attachmentContentRepository.existsById(id);
        if (existsById){
            attachmentContentDTO.setId(id);
            AttachmentContent attachmentContent = mapper.attachmentContentDTOTOAttachmentContent(attachmentContentDTO);
            attachmentContentRepository.save(attachmentContent);
            return new ApiResponse("updated successfully", true);
        }
        return new ApiResponse("no such attachmentConent", false);

    }
}
