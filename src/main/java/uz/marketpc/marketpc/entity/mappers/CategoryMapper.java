package uz.marketpc.marketpc.entity.mappers;

import org.mapstruct.Mapper;
import uz.marketpc.marketpc.entity.Category;
import uz.marketpc.marketpc.entity.dto.CategoryDTO;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO categoryToCategoryDTO(Category category);
    Category categoryDTOToCategory(CategoryDTO categoryDTO);
}
