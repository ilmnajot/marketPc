package uz.marketpc.marketpc.controller;

import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.marketpc.marketpc.entity.Attachment;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.AttachmentDTO;
import uz.marketpc.marketpc.service.AttachmentServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/attachments")
public class AttachmentController {
    private final AttachmentServiceImpl attachmentService;
    @GetMapping("/all")
    @PreAuthorize(value = "hasAuthority('READ_ALL')")
    public List<AttachmentDTO> getAttachments(){
        return attachmentService.findAttachments();
    }
    @PostMapping
    @PreAuthorize(value = "hasAuthority('CREATE')")
    public HttpEntity<?> saveAttachment(@RequestBody AttachmentDTO attachmentDTO){
        ApiResponse apiResponse = attachmentService.addAttachment(attachmentDTO);
        if (apiResponse.isSuccess()){
            return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_EXTENDED).body(apiResponse);
    }
    @GetMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('READ_ONE')")
    public HttpEntity<?> getById(@PathVariable Long id){
       return ResponseEntity.ok(attachmentService.getAttachment(id));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('DELETE')")
    public HttpEntity<?> deleteAttachment(@PathVariable Long id){
        ApiResponse apiResponse = attachmentService.deleteAttachment(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('UPDATE')")
    public HttpEntity<?> updateAttachment(@PathVariable Long id, @RequestBody AttachmentDTO attachmentDTO){
        ApiResponse apiResponse = attachmentService.editAttachment(id, attachmentDTO);
            return ResponseEntity.status(apiResponse.isSuccess() ? 201:409).body(apiResponse);
    }
}
