package uz.marketpc.marketpc.service;

import uz.marketpc.marketpc.entity.Category;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategory();
    ApiResponse addCategory(CategoryDTO categoryDTO);
    Category getCategoryById(Long id);
    ApiResponse deleteById(Long id);
    ApiResponse editById(Long id, CategoryDTO categoryDTO);
}
