package uz.marketpc.marketpc.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.CategoryDTO;
import uz.marketpc.marketpc.service.CategoryService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/all")
    public List<CategoryDTO> getCategories(){
        return categoryService.getAllCategory();
    }
    @PostMapping
    public HttpEntity<?> saveCategory(@RequestBody CategoryDTO categoryDTO){
       return ResponseEntity.ok(categoryService.addCategory(categoryDTO));
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));

    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteById(@PathVariable Long id){
        ApiResponse apiResponse = categoryService.deleteById(id);
        if (apiResponse.isSuccess()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> updateById(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
    return ResponseEntity.ok(categoryService.editById(id, categoryDTO));
    }
}
