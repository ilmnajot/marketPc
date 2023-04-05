package uz.marketpc.marketpc.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.marketpc.marketpc.entity.Blogs;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.BlogsDTO;
import uz.marketpc.marketpc.service.BlogsService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/blogs")
public class BlogsController {
        private final BlogsService blogsService;
    @GetMapping("/all")
    @PreAuthorize(value = "hasAuthority('READ_ALL')")
    public HttpEntity<?> getBlogs(){
        return ResponseEntity.ok(blogsService.findAllBlogs());
    }
    @PostMapping
    @PreAuthorize(value = "hasAuthority('CREATE')")
    public HttpEntity<?> saveBlogs(@RequestBody BlogsDTO blogsDTO){
        return ResponseEntity.ok(blogsService.saveBlogs(blogsDTO));
    }
    @GetMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('READ_ONE')")
    public HttpEntity<?> getById(@PathVariable Long id){
       return ResponseEntity.ok(blogsService.getBlogs(id));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('DELETE')")
    public HttpEntity<?> deleteBlogs(@PathVariable Long id){
        ApiResponse apiResponse = blogsService.deleteBlogs(id);
        if (apiResponse.isSuccess()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);

    }
    @PutMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('UPDATE')")
    public HttpEntity<?> updateBlog(@PathVariable Long id, @RequestBody BlogsDTO blogsDTO){
    return ResponseEntity.ok(blogsService.editBlogs(id,blogsDTO));
    }
}
