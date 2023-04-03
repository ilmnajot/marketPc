package uz.marketpc.marketpc.entity.mappers;

import org.mapstruct.Mapper;
import uz.marketpc.marketpc.entity.Blogs;
import uz.marketpc.marketpc.entity.dto.BlogsDTO;

@Mapper(componentModel = "spring"
)
public interface BlogsMapper {

    BlogsDTO BlogsToBlogsDTO(Blogs blogs);
    Blogs BlogsDTOToBlogs(BlogsDTO blogsDTO);


}
