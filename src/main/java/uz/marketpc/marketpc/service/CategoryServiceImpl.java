package uz.marketpc.marketpc.service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.marketpc.marketpc.entity.Category;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.CategoryDTO;
import uz.marketpc.marketpc.entity.mappers.CategoryMapper;
import uz.marketpc.marketpc.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;
    private CategoryMapper mapper;
    @Override
    public List<CategoryDTO> getAllCategory() {
        return  categoryRepository.findAll(Sort.by("id"))
                .stream()
                .map(mapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }
    @Override
    public ApiResponse addCategory(CategoryDTO categoryDTO) {
        Category category = mapper.categoryDTOToCategory(categoryDTO);
        categoryRepository.save(category);
        return new ApiResponse("category saved successfully", true);
    }

    @Override
    public Category getCategoryById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent())
            return categoryRepository.findById(id).get();
        return null;
    }
    @Override
    public ApiResponse deleteById(Long id) {
        boolean existsById = categoryRepository.existsById(id);
    if (existsById){
        categoryRepository.deleteById(id);
        return new ApiResponse("deleted successfully", true);
    }
    return new ApiResponse("category is not existent", false);
    }

    @Override
    public ApiResponse editById(Long id, CategoryDTO categoryDTO) {
        boolean existsById = categoryRepository.existsById(id);
        if (existsById){
            categoryDTO.setId(id);
            Category category = mapper.categoryDTOToCategory(categoryDTO);
            categoryRepository.save(category);
            return new ApiResponse("updated", true);
        }
        return new ApiResponse("no category", false);
    }

}
