package uz.marketpc.marketpc.service;

import uz.marketpc.marketpc.entity.Blogs;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.BlogsDTO;

import java.util.List;

public interface BlogsService {

     List<BlogsDTO>  findAllBlogs();
     ApiResponse saveBlogs(BlogsDTO blogsDTO);
     Blogs getBlogs(Long id);
    ApiResponse deleteBlogs(Long id);
    ApiResponse editBlogs(Long id, BlogsDTO blogsDTO);
}
