package uz.marketpc.marketpc.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.AttachmentContentDTO;
import uz.marketpc.marketpc.service.AttachmentContentService;
import java.util.List;

@RestController
@RequestMapping("/api/attachContent")
@AllArgsConstructor
public class AttachmentContentController {

    private final AttachmentContentService attachmentContentService;

    @GetMapping("/all")
    @PreAuthorize(value = "hasAuthority('READ_ALL')")
    public List<AttachmentContentDTO> getAllAttachContents(){
        return attachmentContentService.getAllAttachmentContent();
    }

    @PostMapping
    @PreAuthorize(value = "hasAuthority('CREATE')")
    public HttpEntity<?> saveAttachmentContent(@RequestBody AttachmentContentDTO attachmentContentDTO){
        ApiResponse apiResponse = attachmentContentService.addAttachmentContent(attachmentContentDTO);
            return ResponseEntity.status(apiResponse.isSuccess() ? 201:409).body(apiResponse);
    }
    @GetMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('READ_ONE')")
    public HttpEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(attachmentContentService.getById(id));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('DELETE')")
    public HttpEntity<?> deleteById(@PathVariable Long id){
        ApiResponse apiResponse = attachmentContentService.deleteAttachmentContent(id);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('UPDATE')")
    public HttpEntity<?> updateAttachmentContent(@PathVariable Long id, @RequestBody AttachmentContentDTO attachmentContentDTO){
        ApiResponse apiResponse = attachmentContentService.updateContent(id, attachmentContentDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
}
