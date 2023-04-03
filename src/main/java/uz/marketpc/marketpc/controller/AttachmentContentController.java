package uz.marketpc.marketpc.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.AttachmentContentDTO;
import uz.marketpc.marketpc.service.AttachmentContentService;
import java.util.List;

@RestController
@RequestMapping("/api/AttachContent")
@AllArgsConstructor
public class AttachmentContentController {

    private final AttachmentContentService attachmentContentService;

    @GetMapping("/all")
    public List<AttachmentContentDTO> getAllAttachContents(){
        return attachmentContentService.getAllAttachmentContent();
    }

    @PostMapping
    public HttpEntity<?> saveAttachmentContent(@RequestBody AttachmentContentDTO attachmentContentDTO){
        ApiResponse apiResponse = attachmentContentService.addAttachmentContent(attachmentContentDTO);
            return ResponseEntity.status(apiResponse.isSuccess() ? 201:409).body(apiResponse);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(attachmentContentService.getById(id));
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteById(@PathVariable Long id){
        ApiResponse apiResponse = attachmentContentService.deleteAttachmentContent(id);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> updateAttachmentContent(@PathVariable Long id, @RequestBody AttachmentContentDTO attachmentContentDTO){
        ApiResponse apiResponse = attachmentContentService.updateContent(id, attachmentContentDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
}
