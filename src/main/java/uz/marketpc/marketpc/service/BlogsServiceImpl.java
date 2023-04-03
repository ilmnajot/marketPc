package uz.marketpc.marketpc.service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.marketpc.marketpc.entity.Blogs;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.BlogsDTO;
import uz.marketpc.marketpc.entity.mappers.BlogsMapper;
import uz.marketpc.marketpc.repository.BlogsRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BlogsServiceImpl  implements  BlogsService{
   private final BlogsRepository blogsRepository;
   private final BlogsMapper mapper;
    @Override
    public List<BlogsDTO> findAllBlogs() {
        return blogsRepository.findAll(Sort.by("id"))
                .stream()
                .map(mapper::BlogsToBlogsDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ApiResponse saveBlogs(BlogsDTO blogsDTO) {
        Blogs blogs = mapper.BlogsDTOToBlogs(blogsDTO);
        blogsRepository.save(blogs);
        return new ApiResponse("saved", true);
    }

    @Override
    public Blogs getBlogs(Long id) {
        Optional<Blogs> byId = blogsRepository.findById(id);
        if (byId.isPresent()){
            return blogsRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public ApiResponse deleteBlogs(Long id) {
        boolean existsById = blogsRepository.existsById(id);
        if (existsById){
            blogsRepository.deleteById(id);
            return new ApiResponse("deleted", true);
        }
        return new ApiResponse("no such blogs", false);
    }

    @Override
    public ApiResponse editBlogs(Long id, BlogsDTO blogsDTO) {
        boolean existsById = blogsRepository.existsById(id);
        if (existsById){
            blogsDTO.setId(id);
            Blogs blogs = mapper.BlogsDTOToBlogs(blogsDTO);
            blogsRepository.save(blogs);
            return new ApiResponse("updated successfully", true);
        }
        return new ApiResponse("no existent to update", false);
    }
}
